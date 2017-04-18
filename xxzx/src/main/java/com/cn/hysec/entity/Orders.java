package com.cn.hysec.entity;


public class Orders {
    @Override
	public String toString() {
		return "Orders [oderNumber=" + oderNumber + ", resId=" + resId + ", userId=" + userId + ", oederDate="
				+ oederDate + ", orderBatch=" + orderBatch + ", orderQuantity=" + orderQuantity + ", toString()="
				+ super.toString() + "]";
	}

	private Integer oderNumber;

    private Integer resId;

    private Integer userId;

    private String oederDate;

    private String orderBatch;

    private Integer orderQuantity;

    public Integer getOderNumber() {
        return oderNumber;
    }

    public void setOderNumber(Integer oderNumber) {
        this.oderNumber = oderNumber;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOederDate() {
        return oederDate;
    }

    public void setOederDate(String oederDate) {
        this.oederDate = oederDate;
    }

    public String getOrderBatch() {
        return orderBatch;
    }

    public void setOrderBatch(String orderBatch) {
        this.orderBatch = orderBatch == null ? null : orderBatch.trim();
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}