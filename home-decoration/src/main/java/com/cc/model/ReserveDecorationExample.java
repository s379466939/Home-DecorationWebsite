package com.cc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReserveDecorationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReserveDecorationExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("r_id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("r_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("r_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("r_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("r_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("r_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("r_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("r_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("r_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("r_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("r_id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("r_realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("r_realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("r_realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("r_realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("r_realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("r_realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("r_realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("r_realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("r_realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("r_realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("r_realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("r_realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("r_realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("r_realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("r_tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("r_tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(Long value) {
            addCriterion("r_tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(Long value) {
            addCriterion("r_tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(Long value) {
            addCriterion("r_tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(Long value) {
            addCriterion("r_tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(Long value) {
            addCriterion("r_tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(Long value) {
            addCriterion("r_tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<Long> values) {
            addCriterion("r_tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<Long> values) {
            addCriterion("r_tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(Long value1, Long value2) {
            addCriterion("r_tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(Long value1, Long value2) {
            addCriterion("r_tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andIsdoneIsNull() {
            addCriterion("r_isDone is null");
            return (Criteria) this;
        }

        public Criteria andIsdoneIsNotNull() {
            addCriterion("r_isDone is not null");
            return (Criteria) this;
        }

        public Criteria andIsdoneEqualTo(Boolean value) {
            addCriterion("r_isDone =", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneNotEqualTo(Boolean value) {
            addCriterion("r_isDone <>", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneGreaterThan(Boolean value) {
            addCriterion("r_isDone >", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneGreaterThanOrEqualTo(Boolean value) {
            addCriterion("r_isDone >=", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneLessThan(Boolean value) {
            addCriterion("r_isDone <", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneLessThanOrEqualTo(Boolean value) {
            addCriterion("r_isDone <=", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneIn(List<Boolean> values) {
            addCriterion("r_isDone in", values, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneNotIn(List<Boolean> values) {
            addCriterion("r_isDone not in", values, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneBetween(Boolean value1, Boolean value2) {
            addCriterion("r_isDone between", value1, value2, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneNotBetween(Boolean value1, Boolean value2) {
            addCriterion("r_isDone not between", value1, value2, "isdone");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("r_userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("r_userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("r_userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("r_userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("r_userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("r_userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("r_userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("r_userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("r_userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("r_userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("r_userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andReservedateIsNull() {
            addCriterion("r_reserveDate is null");
            return (Criteria) this;
        }

        public Criteria andReservedateIsNotNull() {
            addCriterion("r_reserveDate is not null");
            return (Criteria) this;
        }

        public Criteria andReservedateEqualTo(Date value) {
            addCriterionForJDBCDate("r_reserveDate =", value, "reservedate");
            return (Criteria) this;
        }

        public Criteria andReservedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("r_reserveDate <>", value, "reservedate");
            return (Criteria) this;
        }

        public Criteria andReservedateGreaterThan(Date value) {
            addCriterionForJDBCDate("r_reserveDate >", value, "reservedate");
            return (Criteria) this;
        }

        public Criteria andReservedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("r_reserveDate >=", value, "reservedate");
            return (Criteria) this;
        }

        public Criteria andReservedateLessThan(Date value) {
            addCriterionForJDBCDate("r_reserveDate <", value, "reservedate");
            return (Criteria) this;
        }

        public Criteria andReservedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("r_reserveDate <=", value, "reservedate");
            return (Criteria) this;
        }

        public Criteria andReservedateIn(List<Date> values) {
            addCriterionForJDBCDate("r_reserveDate in", values, "reservedate");
            return (Criteria) this;
        }

        public Criteria andReservedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("r_reserveDate not in", values, "reservedate");
            return (Criteria) this;
        }

        public Criteria andReservedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("r_reserveDate between", value1, value2, "reservedate");
            return (Criteria) this;
        }

        public Criteria andReservedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("r_reserveDate not between", value1, value2, "reservedate");
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