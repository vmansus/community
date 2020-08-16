package vmansus.community.model;

import java.util.ArrayList;
import java.util.List;

public class ThumbExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    public ThumbExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andThumbIdIsNull() {
            addCriterion("THUMB_ID is null");
            return (Criteria) this;
        }

        public Criteria andThumbIdIsNotNull() {
            addCriterion("THUMB_ID is not null");
            return (Criteria) this;
        }

        public Criteria andThumbIdEqualTo(Long value) {
            addCriterion("THUMB_ID =", value, "thumbId");
            return (Criteria) this;
        }

        public Criteria andThumbIdNotEqualTo(Long value) {
            addCriterion("THUMB_ID <>", value, "thumbId");
            return (Criteria) this;
        }

        public Criteria andThumbIdGreaterThan(Long value) {
            addCriterion("THUMB_ID >", value, "thumbId");
            return (Criteria) this;
        }

        public Criteria andThumbIdGreaterThanOrEqualTo(Long value) {
            addCriterion("THUMB_ID >=", value, "thumbId");
            return (Criteria) this;
        }

        public Criteria andThumbIdLessThan(Long value) {
            addCriterion("THUMB_ID <", value, "thumbId");
            return (Criteria) this;
        }

        public Criteria andThumbIdLessThanOrEqualTo(Long value) {
            addCriterion("THUMB_ID <=", value, "thumbId");
            return (Criteria) this;
        }

        public Criteria andThumbIdIn(List<Long> values) {
            addCriterion("THUMB_ID in", values, "thumbId");
            return (Criteria) this;
        }

        public Criteria andThumbIdNotIn(List<Long> values) {
            addCriterion("THUMB_ID not in", values, "thumbId");
            return (Criteria) this;
        }

        public Criteria andThumbIdBetween(Long value1, Long value2) {
            addCriterion("THUMB_ID between", value1, value2, "thumbId");
            return (Criteria) this;
        }

        public Criteria andThumbIdNotBetween(Long value1, Long value2) {
            addCriterion("THUMB_ID not between", value1, value2, "thumbId");
            return (Criteria) this;
        }

        public Criteria andThumbIdParentIsNull() {
            addCriterion("THUMB_ID_PARENT is null");
            return (Criteria) this;
        }

        public Criteria andThumbIdParentIsNotNull() {
            addCriterion("THUMB_ID_PARENT is not null");
            return (Criteria) this;
        }

        public Criteria andThumbIdParentEqualTo(Long value) {
            addCriterion("THUMB_ID_PARENT =", value, "thumbIdParent");
            return (Criteria) this;
        }

        public Criteria andThumbIdParentNotEqualTo(Long value) {
            addCriterion("THUMB_ID_PARENT <>", value, "thumbIdParent");
            return (Criteria) this;
        }

        public Criteria andThumbIdParentGreaterThan(Long value) {
            addCriterion("THUMB_ID_PARENT >", value, "thumbIdParent");
            return (Criteria) this;
        }

        public Criteria andThumbIdParentGreaterThanOrEqualTo(Long value) {
            addCriterion("THUMB_ID_PARENT >=", value, "thumbIdParent");
            return (Criteria) this;
        }

        public Criteria andThumbIdParentLessThan(Long value) {
            addCriterion("THUMB_ID_PARENT <", value, "thumbIdParent");
            return (Criteria) this;
        }

        public Criteria andThumbIdParentLessThanOrEqualTo(Long value) {
            addCriterion("THUMB_ID_PARENT <=", value, "thumbIdParent");
            return (Criteria) this;
        }

        public Criteria andThumbIdParentIn(List<Long> values) {
            addCriterion("THUMB_ID_PARENT in", values, "thumbIdParent");
            return (Criteria) this;
        }

        public Criteria andThumbIdParentNotIn(List<Long> values) {
            addCriterion("THUMB_ID_PARENT not in", values, "thumbIdParent");
            return (Criteria) this;
        }

        public Criteria andThumbIdParentBetween(Long value1, Long value2) {
            addCriterion("THUMB_ID_PARENT between", value1, value2, "thumbIdParent");
            return (Criteria) this;
        }

        public Criteria andThumbIdParentNotBetween(Long value1, Long value2) {
            addCriterion("THUMB_ID_PARENT not between", value1, value2, "thumbIdParent");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table THUMB
     *
     * @mbg.generated do_not_delete_during_merge Sun Aug 16 15:26:19 HKT 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table THUMB
     *
     * @mbg.generated Sun Aug 16 15:26:19 HKT 2020
     */
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