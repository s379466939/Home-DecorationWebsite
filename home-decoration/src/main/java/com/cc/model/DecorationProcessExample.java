package com.cc.model;

import java.util.ArrayList;
import java.util.List;

public class DecorationProcessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DecorationProcessExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeIsNull() {
            addCriterion("constructionTime is null");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeIsNotNull() {
            addCriterion("constructionTime is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeEqualTo(String value) {
            addCriterion("constructionTime =", value, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeNotEqualTo(String value) {
            addCriterion("constructionTime <>", value, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeGreaterThan(String value) {
            addCriterion("constructionTime >", value, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeGreaterThanOrEqualTo(String value) {
            addCriterion("constructionTime >=", value, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeLessThan(String value) {
            addCriterion("constructionTime <", value, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeLessThanOrEqualTo(String value) {
            addCriterion("constructionTime <=", value, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeLike(String value) {
            addCriterion("constructionTime like", value, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeNotLike(String value) {
            addCriterion("constructionTime not like", value, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeIn(List<String> values) {
            addCriterion("constructionTime in", values, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeNotIn(List<String> values) {
            addCriterion("constructionTime not in", values, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeBetween(String value1, String value2) {
            addCriterion("constructionTime between", value1, value2, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeNotBetween(String value1, String value2) {
            addCriterion("constructionTime not between", value1, value2, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionContentIsNull() {
            addCriterion("constructionContent is null");
            return (Criteria) this;
        }

        public Criteria andConstructionContentIsNotNull() {
            addCriterion("constructionContent is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionContentEqualTo(String value) {
            addCriterion("constructionContent =", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentNotEqualTo(String value) {
            addCriterion("constructionContent <>", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentGreaterThan(String value) {
            addCriterion("constructionContent >", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentGreaterThanOrEqualTo(String value) {
            addCriterion("constructionContent >=", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentLessThan(String value) {
            addCriterion("constructionContent <", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentLessThanOrEqualTo(String value) {
            addCriterion("constructionContent <=", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentLike(String value) {
            addCriterion("constructionContent like", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentNotLike(String value) {
            addCriterion("constructionContent not like", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentIn(List<String> values) {
            addCriterion("constructionContent in", values, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentNotIn(List<String> values) {
            addCriterion("constructionContent not in", values, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentBetween(String value1, String value2) {
            addCriterion("constructionContent between", value1, value2, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentNotBetween(String value1, String value2) {
            addCriterion("constructionContent not between", value1, value2, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionPicUrlsIsNull() {
            addCriterion("constructionPicUrls is null");
            return (Criteria) this;
        }

        public Criteria andConstructionPicUrlsIsNotNull() {
            addCriterion("constructionPicUrls is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionPicUrlsEqualTo(String value) {
            addCriterion("constructionPicUrls =", value, "constructionPicUrls");
            return (Criteria) this;
        }

        public Criteria andConstructionPicUrlsNotEqualTo(String value) {
            addCriterion("constructionPicUrls <>", value, "constructionPicUrls");
            return (Criteria) this;
        }

        public Criteria andConstructionPicUrlsGreaterThan(String value) {
            addCriterion("constructionPicUrls >", value, "constructionPicUrls");
            return (Criteria) this;
        }

        public Criteria andConstructionPicUrlsGreaterThanOrEqualTo(String value) {
            addCriterion("constructionPicUrls >=", value, "constructionPicUrls");
            return (Criteria) this;
        }

        public Criteria andConstructionPicUrlsLessThan(String value) {
            addCriterion("constructionPicUrls <", value, "constructionPicUrls");
            return (Criteria) this;
        }

        public Criteria andConstructionPicUrlsLessThanOrEqualTo(String value) {
            addCriterion("constructionPicUrls <=", value, "constructionPicUrls");
            return (Criteria) this;
        }

        public Criteria andConstructionPicUrlsLike(String value) {
            addCriterion("constructionPicUrls like", value, "constructionPicUrls");
            return (Criteria) this;
        }

        public Criteria andConstructionPicUrlsNotLike(String value) {
            addCriterion("constructionPicUrls not like", value, "constructionPicUrls");
            return (Criteria) this;
        }

        public Criteria andConstructionPicUrlsIn(List<String> values) {
            addCriterion("constructionPicUrls in", values, "constructionPicUrls");
            return (Criteria) this;
        }

        public Criteria andConstructionPicUrlsNotIn(List<String> values) {
            addCriterion("constructionPicUrls not in", values, "constructionPicUrls");
            return (Criteria) this;
        }

        public Criteria andConstructionPicUrlsBetween(String value1, String value2) {
            addCriterion("constructionPicUrls between", value1, value2, "constructionPicUrls");
            return (Criteria) this;
        }

        public Criteria andConstructionPicUrlsNotBetween(String value1, String value2) {
            addCriterion("constructionPicUrls not between", value1, value2, "constructionPicUrls");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andContract_idIsNull() {
            addCriterion("contract_id is null");
            return (Criteria) this;
        }

        public Criteria andContract_idIsNotNull() {
            addCriterion("contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andContract_idEqualTo(Integer value) {
            addCriterion("contract_id =", value, "contract_id");
            return (Criteria) this;
        }

        public Criteria andContract_idNotEqualTo(Integer value) {
            addCriterion("contract_id <>", value, "contract_id");
            return (Criteria) this;
        }

        public Criteria andContract_idGreaterThan(Integer value) {
            addCriterion("contract_id >", value, "contract_id");
            return (Criteria) this;
        }

        public Criteria andContract_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_id >=", value, "contract_id");
            return (Criteria) this;
        }

        public Criteria andContract_idLessThan(Integer value) {
            addCriterion("contract_id <", value, "contract_id");
            return (Criteria) this;
        }

        public Criteria andContract_idLessThanOrEqualTo(Integer value) {
            addCriterion("contract_id <=", value, "contract_id");
            return (Criteria) this;
        }

        public Criteria andContract_idIn(List<Integer> values) {
            addCriterion("contract_id in", values, "contract_id");
            return (Criteria) this;
        }

        public Criteria andContract_idNotIn(List<Integer> values) {
            addCriterion("contract_id not in", values, "contract_id");
            return (Criteria) this;
        }

        public Criteria andContract_idBetween(Integer value1, Integer value2) {
            addCriterion("contract_id between", value1, value2, "contract_id");
            return (Criteria) this;
        }

        public Criteria andContract_idNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_id not between", value1, value2, "contract_id");
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