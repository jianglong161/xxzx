package com.cn.hysec.entity;

public class OfficeSupplies {
    @Override
	public String toString() {
		return "OfficeSupplies [resId=" + resId + ", resName=" + resName + ", resPrice=" + resPrice + ", toString()="
				+ super.toString() + "]";
	}

	private Integer resId;

    private String resName;

    private Long resPrice;

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    public Long getResPrice() {
        return resPrice;
    }

    public void setResPrice(Long resPrice) {
        this.resPrice = resPrice;
    }
}