package hu.dodotech.bakeryrateapp.common;

public class NavigationItem {
    private String title;
    private int icon;
    private FragmentType type;

    public NavigationItem(String title, int icon, FragmentType type) {
        this.title = title;
        this.icon = icon;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public FragmentType getType() {
        return type;
    }

    public void setType(FragmentType type) {
        this.type = type;
    }
}
