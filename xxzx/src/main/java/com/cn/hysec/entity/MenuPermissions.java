package com.cn.hysec.entity;

public class MenuPermissions {
    @Override
	public String toString() {
		return "MenuPermissions [perId=" + perId + ", userId=" + userId + ", menuId=" + menuId + ", toString()="
				+ super.toString() + "]";
	}

	private Integer perId;

    private Integer userId;

    private Integer menuId;

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}