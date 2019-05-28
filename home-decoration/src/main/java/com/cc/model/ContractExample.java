package com.cc.model;

import java.util.ArrayList;
import java.util.List;

public class ContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("c_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("c_userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("c_userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("c_userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("c_userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("c_userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("c_userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("c_userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("c_userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("c_userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("c_userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("c_userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("c_userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("c_userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("c_userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("c_userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("c_userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("c_userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("c_userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("c_userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("c_userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("c_userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("c_userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("c_userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("c_userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("c_userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andMerchantIsNull() {
            addCriterion("c_merchant is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIsNotNull() {
            addCriterion("c_merchant is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantEqualTo(String value) {
            addCriterion("c_merchant =", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotEqualTo(String value) {
            addCriterion("c_merchant <>", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantGreaterThan(String value) {
            addCriterion("c_merchant >", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantGreaterThanOrEqualTo(String value) {
            addCriterion("c_merchant >=", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantLessThan(String value) {
            addCriterion("c_merchant <", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantLessThanOrEqualTo(String value) {
            addCriterion("c_merchant <=", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantLike(String value) {
            addCriterion("c_merchant like", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotLike(String value) {
            addCriterion("c_merchant not like", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantIn(List<String> values) {
            addCriterion("c_merchant in", values, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotIn(List<String> values) {
            addCriterion("c_merchant not in", values, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantBetween(String value1, String value2) {
            addCriterion("c_merchant between", value1, value2, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotBetween(String value1, String value2) {
            addCriterion("c_merchant not between", value1, value2, "merchant");
            return (Criteria) this;
        }

        public Criteria andContractcontentIsNull() {
            addCriterion("c_contractContent is null");
            return (Criteria) this;
        }

        public Criteria andContractcontentIsNotNull() {
            addCriterion("c_contractContent is not null");
            return (Criteria) this;
        }

        public Criteria andContractcontentEqualTo(String value) {
            addCriterion("c_contractContent =", value, "contractcontent");
            return (Criteria) this;
        }

        public Criteria andContractcontentNotEqualTo(String value) {
            addCriterion("c_contractContent <>", value, "contractcontent");
            return (Criteria) this;
        }

        public Criteria andContractcontentGreaterThan(String value) {
            addCriterion("c_contractContent >", value, "contractcontent");
            return (Criteria) this;
        }

        public Criteria andContractcontentGreaterThanOrEqualTo(String value) {
            addCriterion("c_contractContent >=", value, "contractcontent");
            return (Criteria) this;
        }

        public Criteria andContractcontentLessThan(String value) {
            addCriterion("c_contractContent <", value, "contractcontent");
            return (Criteria) this;
        }

        public Criteria andContractcontentLessThanOrEqualTo(String value) {
            addCriterion("c_contractContent <=", value, "contractcontent");
            return (Criteria) this;
        }

        public Criteria andContractcontentLike(String value) {
            addCriterion("c_contractContent like", value, "contractcontent");
            return (Criteria) this;
        }

        public Criteria andContractcontentNotLike(String value) {
            addCriterion("c_contractContent not like", value, "contractcontent");
            return (Criteria) this;
        }

        public Criteria andContractcontentIn(List<String> values) {
            addCriterion("c_contractContent in", values, "contractcontent");
            return (Criteria) this;
        }

        public Criteria andContractcontentNotIn(List<String> values) {
            addCriterion("c_contractContent not in", values, "contractcontent");
            return (Criteria) this;
        }

        public Criteria andContractcontentBetween(String value1, String value2) {
            addCriterion("c_contractContent between", value1, value2, "contractcontent");
            return (Criteria) this;
        }

        public Criteria andContractcontentNotBetween(String value1, String value2) {
            addCriterion("c_contractContent not between", value1, value2, "contractcontent");
            return (Criteria) this;
        }

        public Criteria andHouselocationIsNull() {
            addCriterion("c_houseLocation is null");
            return (Criteria) this;
        }

        public Criteria andHouselocationIsNotNull() {
            addCriterion("c_houseLocation is not null");
            return (Criteria) this;
        }

        public Criteria andHouselocationEqualTo(String value) {
            addCriterion("c_houseLocation =", value, "houselocation");
            return (Criteria) this;
        }

        public Criteria andHouselocationNotEqualTo(String value) {
            addCriterion("c_houseLocation <>", value, "houselocation");
            return (Criteria) this;
        }

        public Criteria andHouselocationGreaterThan(String value) {
            addCriterion("c_houseLocation >", value, "houselocation");
            return (Criteria) this;
        }

        public Criteria andHouselocationGreaterThanOrEqualTo(String value) {
            addCriterion("c_houseLocation >=", value, "houselocation");
            return (Criteria) this;
        }

        public Criteria andHouselocationLessThan(String value) {
            addCriterion("c_houseLocation <", value, "houselocation");
            return (Criteria) this;
        }

        public Criteria andHouselocationLessThanOrEqualTo(String value) {
            addCriterion("c_houseLocation <=", value, "houselocation");
            return (Criteria) this;
        }

        public Criteria andHouselocationLike(String value) {
            addCriterion("c_houseLocation like", value, "houselocation");
            return (Criteria) this;
        }

        public Criteria andHouselocationNotLike(String value) {
            addCriterion("c_houseLocation not like", value, "houselocation");
            return (Criteria) this;
        }

        public Criteria andHouselocationIn(List<String> values) {
            addCriterion("c_houseLocation in", values, "houselocation");
            return (Criteria) this;
        }

        public Criteria andHouselocationNotIn(List<String> values) {
            addCriterion("c_houseLocation not in", values, "houselocation");
            return (Criteria) this;
        }

        public Criteria andHouselocationBetween(String value1, String value2) {
            addCriterion("c_houseLocation between", value1, value2, "houselocation");
            return (Criteria) this;
        }

        public Criteria andHouselocationNotBetween(String value1, String value2) {
            addCriterion("c_houseLocation not between", value1, value2, "houselocation");
            return (Criteria) this;
        }

        public Criteria andHousedescriptionIsNull() {
            addCriterion("c_houseDescription is null");
            return (Criteria) this;
        }

        public Criteria andHousedescriptionIsNotNull() {
            addCriterion("c_houseDescription is not null");
            return (Criteria) this;
        }

        public Criteria andHousedescriptionEqualTo(String value) {
            addCriterion("c_houseDescription =", value, "housedescription");
            return (Criteria) this;
        }

        public Criteria andHousedescriptionNotEqualTo(String value) {
            addCriterion("c_houseDescription <>", value, "housedescription");
            return (Criteria) this;
        }

        public Criteria andHousedescriptionGreaterThan(String value) {
            addCriterion("c_houseDescription >", value, "housedescription");
            return (Criteria) this;
        }

        public Criteria andHousedescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("c_houseDescription >=", value, "housedescription");
            return (Criteria) this;
        }

        public Criteria andHousedescriptionLessThan(String value) {
            addCriterion("c_houseDescription <", value, "housedescription");
            return (Criteria) this;
        }

        public Criteria andHousedescriptionLessThanOrEqualTo(String value) {
            addCriterion("c_houseDescription <=", value, "housedescription");
            return (Criteria) this;
        }

        public Criteria andHousedescriptionLike(String value) {
            addCriterion("c_houseDescription like", value, "housedescription");
            return (Criteria) this;
        }

        public Criteria andHousedescriptionNotLike(String value) {
            addCriterion("c_houseDescription not like", value, "housedescription");
            return (Criteria) this;
        }

        public Criteria andHousedescriptionIn(List<String> values) {
            addCriterion("c_houseDescription in", values, "housedescription");
            return (Criteria) this;
        }

        public Criteria andHousedescriptionNotIn(List<String> values) {
            addCriterion("c_houseDescription not in", values, "housedescription");
            return (Criteria) this;
        }

        public Criteria andHousedescriptionBetween(String value1, String value2) {
            addCriterion("c_houseDescription between", value1, value2, "housedescription");
            return (Criteria) this;
        }

        public Criteria andHousedescriptionNotBetween(String value1, String value2) {
            addCriterion("c_houseDescription not between", value1, value2, "housedescription");
            return (Criteria) this;
        }

        public Criteria andConstructiontimeIsNull() {
            addCriterion("c_constructionTime is null");
            return (Criteria) this;
        }

        public Criteria andConstructiontimeIsNotNull() {
            addCriterion("c_constructionTime is not null");
            return (Criteria) this;
        }

        public Criteria andConstructiontimeEqualTo(String value) {
            addCriterion("c_constructionTime =", value, "constructiontime");
            return (Criteria) this;
        }

        public Criteria andConstructiontimeNotEqualTo(String value) {
            addCriterion("c_constructionTime <>", value, "constructiontime");
            return (Criteria) this;
        }

        public Criteria andConstructiontimeGreaterThan(String value) {
            addCriterion("c_constructionTime >", value, "constructiontime");
            return (Criteria) this;
        }

        public Criteria andConstructiontimeGreaterThanOrEqualTo(String value) {
            addCriterion("c_constructionTime >=", value, "constructiontime");
            return (Criteria) this;
        }

        public Criteria andConstructiontimeLessThan(String value) {
            addCriterion("c_constructionTime <", value, "constructiontime");
            return (Criteria) this;
        }

        public Criteria andConstructiontimeLessThanOrEqualTo(String value) {
            addCriterion("c_constructionTime <=", value, "constructiontime");
            return (Criteria) this;
        }

        public Criteria andConstructiontimeLike(String value) {
            addCriterion("c_constructionTime like", value, "constructiontime");
            return (Criteria) this;
        }

        public Criteria andConstructiontimeNotLike(String value) {
            addCriterion("c_constructionTime not like", value, "constructiontime");
            return (Criteria) this;
        }

        public Criteria andConstructiontimeIn(List<String> values) {
            addCriterion("c_constructionTime in", values, "constructiontime");
            return (Criteria) this;
        }

        public Criteria andConstructiontimeNotIn(List<String> values) {
            addCriterion("c_constructionTime not in", values, "constructiontime");
            return (Criteria) this;
        }

        public Criteria andConstructiontimeBetween(String value1, String value2) {
            addCriterion("c_constructionTime between", value1, value2, "constructiontime");
            return (Criteria) this;
        }

        public Criteria andConstructiontimeNotBetween(String value1, String value2) {
            addCriterion("c_constructionTime not between", value1, value2, "constructiontime");
            return (Criteria) this;
        }

        public Criteria andContractstateIsNull() {
            addCriterion("c_contractState is null");
            return (Criteria) this;
        }

        public Criteria andContractstateIsNotNull() {
            addCriterion("c_contractState is not null");
            return (Criteria) this;
        }

        public Criteria andContractstateEqualTo(Boolean value) {
            addCriterion("c_contractState =", value, "contractstate");
            return (Criteria) this;
        }

        public Criteria andContractstateNotEqualTo(Boolean value) {
            addCriterion("c_contractState <>", value, "contractstate");
            return (Criteria) this;
        }

        public Criteria andContractstateGreaterThan(Boolean value) {
            addCriterion("c_contractState >", value, "contractstate");
            return (Criteria) this;
        }

        public Criteria andContractstateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("c_contractState >=", value, "contractstate");
            return (Criteria) this;
        }

        public Criteria andContractstateLessThan(Boolean value) {
            addCriterion("c_contractState <", value, "contractstate");
            return (Criteria) this;
        }

        public Criteria andContractstateLessThanOrEqualTo(Boolean value) {
            addCriterion("c_contractState <=", value, "contractstate");
            return (Criteria) this;
        }

        public Criteria andContractstateIn(List<Boolean> values) {
            addCriterion("c_contractState in", values, "contractstate");
            return (Criteria) this;
        }

        public Criteria andContractstateNotIn(List<Boolean> values) {
            addCriterion("c_contractState not in", values, "contractstate");
            return (Criteria) this;
        }

        public Criteria andContractstateBetween(Boolean value1, Boolean value2) {
            addCriterion("c_contractState between", value1, value2, "contractstate");
            return (Criteria) this;
        }

        public Criteria andContractstateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("c_contractState not between", value1, value2, "contractstate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}