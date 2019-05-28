package com.cc.service;

import com.cc.model.*;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

public interface UserService {

    boolean hasAccount(User user);

    User getUserByAccount(User user);

    Role getRoleById(int id);

    boolean insertUserSelective(User user);

    boolean insertGalleryDesign(GalleryDesign galleryDesign);

    List<GalleryDesign> getAllGalleryDesing();

    boolean insertReserveDecoration(ReserveDecoration reserveDecoration);

    List<ReserveDecoration> getAllReservationsByUserId(int UserId);

    List<ReserveDecoration> getAllReservations();

    boolean modifyReservationStateById(boolean resState, int id);

    boolean insertContractSelective(Contract contract);

    List<Contract> getAllContract();

    List<Contract> selectContractByUserId(int userId);

    boolean modifyContractStateById(boolean conState, int id);

    boolean insertDecorationProcess(DecorationProcess decorationProcess);

    List<DecorationProcess> selectDecorationProcessByContractId(int contractId);

    List<GalleryDesign> filteGalleryDesign(JSONObject jsonObject);

    Map<String, Object> filteGalleryDesignByPage(JSONObject jsonObject, Page page);
}
