/** Устройство умного дома
 *
 */
public class Device<T, R> implements IManageDevice {
    private T id;
    private R status;
    private String name;
    private String displayName;

    public Device() {}
    public Device(T id, R status) {
        this.id = id;
    }
    public Device(T id, R status, String name, String displayName) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.displayName = displayName;
    }

    public T getId() { return id; }
    public void setId(T id) {
        this.id = id;
    }

    public R getStatus() {
        return status;
    }
    public void setStatus(R status) { this.status = status; }
    public void setStatus(String status) { this.status = (R)status; }
    public void setStatus(Integer status) { this.status = (R)status; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String CurrStatus() {
        String currStatus;
        if ((status == null) || (String.valueOf(status) == null)) {
            currStatus = "неизвестен";
        } else {
            switch (status.toString()) {
                case "1": currStatus = "вкл"; break;
                case "2": currStatus = "подготовка"; break;
                case "3": currStatus = "ожидание"; break;
                case "0": currStatus = "выкл"; break;
                case "Вкл": currStatus = "вкл"; break;
                case "Выкл": currStatus = "выкл"; break;
                default: currStatus = "неизвестно"; break;
            }
        };
        return currStatus;
    }

    @Override
    public void OnOff(int action) {
        if (String.valueOf(action) != null) {
            if (action == 1) {
                if (getStatus() instanceof String) {
                    setStatus("Вкл");
                } else if (getStatus() instanceof Integer) {
                    setStatus(1);
                }
            } else {
                if (getStatus() instanceof String) {
                    setStatus("Выкл");
                } else if (getStatus() instanceof Integer) {
                    setStatus(0);
                }
            }
        }
    }

    @Override
    public String DisplayStatus() {
        return "Идентификатор устройства: " + getId() +
               "\tНаименование: " + getDisplayName() +
               "\tСтатус: " + CurrStatus();
                //(getStatus() instanceof Integer ? ((Integer)getStatus()==1 ? "Вкл" : "Выкл") : getStatus().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device<?, ?> device = (Device<?, ?>) o;

        if (getId() != null ? !getId().equals(device.getId()) : device.getId() != null) return false;
        if (getStatus() != null ? !getStatus().equals(device.getStatus()) : device.getStatus() != null) return false;
        if (getName() != null ? !getName().equals(device.getName()) : device.getName() != null) return false;
        return getDisplayName() != null ? getDisplayName().equals(device.getDisplayName()) : device.getDisplayName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDisplayName() != null ? getDisplayName().hashCode() : 0);
        return result;
    }
}
