package cn.hzby.lhj.po;

import java.util.ArrayList;
import java.util.List;

public class Summary5minExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Summary5minExample() {
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

        public Criteria andTimestampIsNull() {
            addCriterion("timestamp is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(Integer value) {
            addCriterion("timestamp =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(Integer value) {
            addCriterion("timestamp <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(Integer value) {
            addCriterion("timestamp >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(Integer value) {
            addCriterion("timestamp >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(Integer value) {
            addCriterion("timestamp <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(Integer value) {
            addCriterion("timestamp <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<Integer> values) {
            addCriterion("timestamp in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<Integer> values) {
            addCriterion("timestamp not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(Integer value1, Integer value2) {
            addCriterion("timestamp between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(Integer value1, Integer value2) {
            addCriterion("timestamp not between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andElectricityIsNull() {
            addCriterion("electricity is null");
            return (Criteria) this;
        }

        public Criteria andElectricityIsNotNull() {
            addCriterion("electricity is not null");
            return (Criteria) this;
        }

        public Criteria andElectricityEqualTo(Integer value) {
            addCriterion("electricity =", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotEqualTo(Integer value) {
            addCriterion("electricity <>", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityGreaterThan(Integer value) {
            addCriterion("electricity >", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityGreaterThanOrEqualTo(Integer value) {
            addCriterion("electricity >=", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityLessThan(Integer value) {
            addCriterion("electricity <", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityLessThanOrEqualTo(Integer value) {
            addCriterion("electricity <=", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityIn(List<Integer> values) {
            addCriterion("electricity in", values, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotIn(List<Integer> values) {
            addCriterion("electricity not in", values, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityBetween(Integer value1, Integer value2) {
            addCriterion("electricity between", value1, value2, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotBetween(Integer value1, Integer value2) {
            addCriterion("electricity not between", value1, value2, "electricity");
            return (Criteria) this;
        }

        public Criteria andAirIsNull() {
            addCriterion("air is null");
            return (Criteria) this;
        }

        public Criteria andAirIsNotNull() {
            addCriterion("air is not null");
            return (Criteria) this;
        }

        public Criteria andAirEqualTo(Integer value) {
            addCriterion("air =", value, "air");
            return (Criteria) this;
        }

        public Criteria andAirNotEqualTo(Integer value) {
            addCriterion("air <>", value, "air");
            return (Criteria) this;
        }

        public Criteria andAirGreaterThan(Integer value) {
            addCriterion("air >", value, "air");
            return (Criteria) this;
        }

        public Criteria andAirGreaterThanOrEqualTo(Integer value) {
            addCriterion("air >=", value, "air");
            return (Criteria) this;
        }

        public Criteria andAirLessThan(Integer value) {
            addCriterion("air <", value, "air");
            return (Criteria) this;
        }

        public Criteria andAirLessThanOrEqualTo(Integer value) {
            addCriterion("air <=", value, "air");
            return (Criteria) this;
        }

        public Criteria andAirIn(List<Integer> values) {
            addCriterion("air in", values, "air");
            return (Criteria) this;
        }

        public Criteria andAirNotIn(List<Integer> values) {
            addCriterion("air not in", values, "air");
            return (Criteria) this;
        }

        public Criteria andAirBetween(Integer value1, Integer value2) {
            addCriterion("air between", value1, value2, "air");
            return (Criteria) this;
        }

        public Criteria andAirNotBetween(Integer value1, Integer value2) {
            addCriterion("air not between", value1, value2, "air");
            return (Criteria) this;
        }

        public Criteria andUnitCostIsNull() {
            addCriterion("unit_cost is null");
            return (Criteria) this;
        }

        public Criteria andUnitCostIsNotNull() {
            addCriterion("unit_cost is not null");
            return (Criteria) this;
        }

        public Criteria andUnitCostEqualTo(Float value) {
            addCriterion("unit_cost =", value, "unitCost");
            return (Criteria) this;
        }

        public Criteria andUnitCostNotEqualTo(Float value) {
            addCriterion("unit_cost <>", value, "unitCost");
            return (Criteria) this;
        }

        public Criteria andUnitCostGreaterThan(Float value) {
            addCriterion("unit_cost >", value, "unitCost");
            return (Criteria) this;
        }

        public Criteria andUnitCostGreaterThanOrEqualTo(Float value) {
            addCriterion("unit_cost >=", value, "unitCost");
            return (Criteria) this;
        }

        public Criteria andUnitCostLessThan(Float value) {
            addCriterion("unit_cost <", value, "unitCost");
            return (Criteria) this;
        }

        public Criteria andUnitCostLessThanOrEqualTo(Float value) {
            addCriterion("unit_cost <=", value, "unitCost");
            return (Criteria) this;
        }

        public Criteria andUnitCostIn(List<Float> values) {
            addCriterion("unit_cost in", values, "unitCost");
            return (Criteria) this;
        }

        public Criteria andUnitCostNotIn(List<Float> values) {
            addCriterion("unit_cost not in", values, "unitCost");
            return (Criteria) this;
        }

        public Criteria andUnitCostBetween(Float value1, Float value2) {
            addCriterion("unit_cost between", value1, value2, "unitCost");
            return (Criteria) this;
        }

        public Criteria andUnitCostNotBetween(Float value1, Float value2) {
            addCriterion("unit_cost not between", value1, value2, "unitCost");
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