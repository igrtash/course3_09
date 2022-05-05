import java.util.Objects;

/** Прибор отопления
 *
 */
public class Heating <T, R> extends Device implements IManageDevice {
    private Integer temperatureWarm = 0;
    private Integer temperatureCurrent = 0;

    private void setNewStatus() {
        String currStatus = super.CurrStatus();
        if (currStatus != "0" && currStatus != "выкл") {
            if (temperatureWarm > temperatureCurrent) {
                super.setStatus(2); // нагрев
            } else if (temperatureWarm < temperatureCurrent) {
                super.setStatus(3); // перейдем в режим ожидания
            }
        }
    }

    public Heating() {
        super();
    }

    public Heating(T id, R status, String name, String displayName, Integer temperatureWarm) {
        super(id, status, name, displayName);
        this.temperatureWarm = temperatureWarm;
    }

    public Integer getTemperatureWarm() {
        return temperatureWarm;
    }

    public void setTemperatureWarm(Integer temperatureWarm) {
        this.temperatureWarm = temperatureWarm;
        setNewStatus(); // обновим статус
    }

    public Integer getTemperatureCurrent() {
        return temperatureCurrent;
    }

    public void setTemperatureCurrent(Integer temperatureCurrent) {
        this.temperatureCurrent = temperatureCurrent;
        setNewStatus(); // обновим статус
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Heating)) return false;
        Heating<?, ?> heating = (Heating<?, ?>) o;
        if (getId() != null ? !getId().equals(heating.getId()) : heating.getId() != null) return false;
        if (getStatus() != null ? !getStatus().equals(heating.getStatus()) : heating.getStatus() != null) return false;
        if (getName() != null ? !getName().equals(heating.getName()) : heating.getName() != null) return false;
        if (getDisplayName() != null ? !getDisplayName().equals(heating.getDisplayName()) : heating.getDisplayName() != null) return false;
        return getTemperatureWarm().equals(heating.getTemperatureWarm()) && getTemperatureCurrent().equals(heating.getTemperatureCurrent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), super.getName(), temperatureWarm);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
                "id=" + super.getId() +
                ", status=" + super.getStatus() +
                ", name='" + super.getName() + '\'' +
                ", displayName='" + super.getDisplayName() + '\'' +
                ", temperatureSet=" + temperatureWarm +
                ", temperatureCurrent=" + temperatureCurrent +
                "}";
    }

    @Override
    public void OnOff(int action) {
        super.OnOff(action);
        setNewStatus(); // обновим статус в завимости от температур
    }

    @Override
    public String DisplayStatus() {
        return "Устройство: отопления" +
                "\tИдентификатор: " + super.getId() +
                "\tНаименование=" + super.getDisplayName() +
                "\tСтатус=" + (super.CurrStatus() == "подготовка" ? "идет нагрев" : super.CurrStatus()) +
                "\tТек. температура=" + temperatureCurrent;
    }

}
