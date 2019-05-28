package com.cc.service;


import com.cc.controller.HomeDecorationController;
import com.cc.controller.Test;
import com.cc.dao.*;
import com.cc.model.*;
import com.cc.util.StringUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

     static final private String tag = "com.cc.service.UserServiceImpl";

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    GalleryDesignMapper galleryDesignMapper;

    @Autowired
    ReserveDecorationMapper reserveDecorationMapper;

    @Autowired
    ContractMapper contractMapper;

    @Autowired
    DecorationProcessMapper decorationProcessMapper;

    //判断是否存在用户名和密码
    public boolean hasAccount(User user) {
        UserExample userExample = new UserExample();
        userExample.or().andAccountEqualTo(user.getAccount()).andPasswordEqualTo(user.getPassword());
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size() == 1) {
            return true;
        }

        return false;
    }

    public User getUserByAccount(User user) {
        UserExample userExample = new UserExample();
        userExample.or().andAccountEqualTo(user.getAccount());
        List<User> list = userMapper.selectByExample(userExample);
        //返回list结果集里唯一一个对象
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public Role getRoleById(int id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        return role;
    }

    public boolean insertUserSelective(User user) {
        //判断用户名是否存在
        User u = getUserByAccount(user);
        if (u != null) {
            System.out.println("用户名已存在！");
            return false;
        }


        try {
            int rows = userMapper.insertSelective(user);
            //更新行数大于1则插入成功
            if (rows > 0) {
                return true;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertGalleryDesign(GalleryDesign galleryDesign) {
        int rows = galleryDesignMapper.insertSelective(galleryDesign);
        return rows > 0;
    }


    public List<GalleryDesign> getAllGalleryDesing() {
        List<GalleryDesign> list = galleryDesignMapper.selectByExample(new GalleryDesignExample());
        return list;
    }

    public boolean insertReserveDecoration(ReserveDecoration reserveDecoration) {
        int rows = reserveDecorationMapper.insertSelective(reserveDecoration);

        return rows > 0;
    }

    public List<ReserveDecoration> getAllReservationsByUserId(int UserId) {
        ReserveDecorationExample reserveDecorationExample = new ReserveDecorationExample();
        reserveDecorationExample.or().andUseridEqualTo(UserId);
        List<ReserveDecoration> list = reserveDecorationMapper.selectByExample(reserveDecorationExample);
        return list;
    }

    public List<ReserveDecoration> getAllReservations() {
        List<ReserveDecoration> list = reserveDecorationMapper.selectByExample(new ReserveDecorationExample());
        return list;
    }

    public boolean insertDecorationProcess(DecorationProcess decorationProcess) {
        int rows = decorationProcessMapper.insertSelective(decorationProcess);
        return rows > 0;
    }


    public boolean modifyReservationStateById(boolean resState, int id) {
        ReserveDecoration reserveDecoration = new ReserveDecoration();
        reserveDecoration.setIsdone(!resState);
        reserveDecoration.setId(id);
        int rows = reserveDecorationMapper.updateByPrimaryKeySelective(reserveDecoration);
        return rows > 0;
    }

    public boolean insertContractSelective(Contract contract) {
        int rows = contractMapper.insertSelective(contract);
        return rows > 0;
    }

    public List<Contract> getAllContract() {
        List<Contract> list = contractMapper.selectByExample(new ContractExample());
        return list;
    }

    public List<Contract> selectContractByUserId(int userId) {
        ContractExample contractExample = new ContractExample();
        contractExample.or().andUseridEqualTo(userId);
        List<Contract> contractList = contractMapper.selectByExample(contractExample);
        return contractList;
    }

    public boolean modifyContractStateById(boolean conState, int id) {
        Contract contract = new Contract();
        contract.setContractstate(!conState);
        contract.setId(id);
        int rows = contractMapper.updateByPrimaryKeySelective(contract);
        return rows > 0;
    }

    public List<DecorationProcess> selectDecorationProcessByContractId(int contractId) {
        DecorationProcessExample decorationProcessExample = new DecorationProcessExample();
        decorationProcessExample.or().andContract_idEqualTo(contractId);
        List<DecorationProcess> list = decorationProcessMapper.selectByExample(decorationProcessExample);
        return list;
    }

    public List<GalleryDesign> filteGalleryDesign(JSONObject jsonObject) {
        Map<String, Object> map = StringUtil.filteChoiceByJSONObject(jsonObject);
        GalleryDesignExample galleryDesignExample = new GalleryDesignExample();
        galleryDesignExample.or().andHousetypeEqualTo(map.get("houseType").toString())
                .andCostBetween((int[]) map.get("cost"))
                .andAreaBetween((int[]) map.get("area"))
                .andStyleEqualTo(map.get("style").toString());
        List<GalleryDesign> list = galleryDesignMapper.selectByExample(galleryDesignExample);
        return list;

    }

    public Map<String, Object> filteGalleryDesignByPage(JSONObject jsonObject, Page page) {
        Map<String, Object> map = StringUtil.filteChoiceByJSONObject(jsonObject);
        GalleryDesignExample galleryDesignExample = new GalleryDesignExample();
        galleryDesignExample.or().andHousetypeEqualTo(map.get("houseType").toString())
                .andCostBetween((int[]) map.get("cost"))
                .andAreaBetween((int[]) map.get("area"))
                .andStyleEqualTo(map.get("style").toString());
        int count = galleryDesignMapper.countByExample(galleryDesignExample);
        int currPage = page.getCurrPage() == 0 ? 1 : page.getCurrPage();//当前页数
//        int pageSize = page.getPageSize() == 0 ? HomeDecorationController.PageSize : page.getPageSize();//查询个数
        int pageSize = HomeDecorationController.PageSize;
        int totalPage = count % pageSize == 0 ? (count / pageSize) : (count / pageSize + 1);
        Page pageObject = new Page(currPage, pageSize);
        pageObject.setTotalPage(totalPage);
        System.out.println(tag + ":  filteGalleryDesignByPage:  pageObject: " + pageObject.toString());
        galleryDesignExample.setOrderByClause("id desc limit " + (currPage - 1) * pageSize + "," + pageSize);
        List<GalleryDesign> galleryDesignList = galleryDesignMapper.selectByExample(galleryDesignExample);
        System.out.println(tag + ":  filteGalleryDesignByPage:  galleryDesignList: " + galleryDesignList);

        //创建hashMap存放pageObject和galleryDesignList
        map = new HashMap<String, Object>();
        map.put("pageObject", pageObject);
        map.put("galleryDesignList", galleryDesignList);
        return map;
    }
}
