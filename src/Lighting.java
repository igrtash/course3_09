import java.util.Objects;

/** Осветительный прибор
 *
 */
//public class Lighting <T, R extends Device & IManageDevice> {
public class Lighting <T, R> extends Device implements IManageDevice {
    private Colour colour; //Цветность

    public Lighting() {
        super();
    }

    public Lighting(T id, R status, String name, String displayName, Colour colour) {
        super(id, status, name, displayName);
        this.colour = colour;
    }

    public Lighting(Device device) {
        /*super();
        super.setId(device.getId());
        super.setStatus(device.getStatus());
        super.setName(device.getName());
        super.setDisplayName(device.getDisplayName());*/
        super(device.getId(), device.getStatus(), device.getName(), device.getDisplayName());
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lighting<?, ?> lighting = (Lighting<?, ?>) o;
        if (getId() != null ? !getId().equals(lighting.getId()) : lighting.getId() != null) return false;
        if (getStatus() != null ? !getStatus().equals(lighting.getStatus()) : lighting.getStatus() != null) return false;
        if (getName() != null ? !getName().equals(lighting.getName()) : lighting.getName() != null) return false;
        if (getDisplayName() != null ? !getDisplayName().equals(lighting.getDisplayName()) : lighting.getDisplayName() != null) return false;
        return colour == lighting.colour;
    }

    @Override
    public int hashCode() {
        //return Objects.hash(super.id, super.status, super.name, super.displayName, colour);
        return Objects.hash(super.getId(), super.getName(), colour);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
                "id=" + super.getId() +
                ", status=" + super.getStatus() +
                ", name='" + super.getName() + '\'' +
                ", displayName='" + super.getDisplayName() + '\'' +
                ", colour=" + colour +
                '}';
    }

    @Override
    public String DisplayStatus() {
        return "Устройство: осветительный прибор" +
                "\tИдентификатор: " + super.getId() +
                "\tНаименование=" + super.getDisplayName() +
                "\tСтатус=" + super.CurrStatus() +
                "\tЦветность=" + colour;
    }

}
