package com.cn.hysec.entity;

public class Menu {
    @Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", menuLink=" + menuLink + ", toString()="
				+ super.toString() + "]";
	}

	private Integer menuId;

    private String menuName;

    private String menuLink;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuLink() {
        return menuLink;
    }

    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink == null ? null : menuLink.trim();
    }
}