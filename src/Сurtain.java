import java.awt.*;
import java.util.Objects;
import java.lang.reflect.Field;

/** Шторы
 *
 */
public class Сurtain <T, R> extends Device implements IManageDevice {
    private Color color;

    public Сurtain() {
        super();
    }


    public Сurtain(T id, R status, String name, String displayName, Color color) {
            super(id, status, name, displayName);
            this.color = color;
        }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Сurtain<?, ?> сurtain = (Сurtain<?, ?>) o;
        if (getId() != null ? !getId().equals(сurtain.getId()) : сurtain.getId() != null) return false;
        if (getStatus() != null ? !getStatus().equals(сurtain.getStatus()) : сurtain.getStatus() != null) return false;
        if (getName() != null ? !getName().equals(сurtain.getName()) : сurtain.getName() != null) return false;
        if (getDisplayName() != null ? !getDisplayName().equals(сurtain.getDisplayName()) : сurtain.getDisplayName() != null) return false;
        return getColor().equals(сurtain.getColor());
    }

    @Override
    public int hashCode() {
        //return Objects.hash(super.id, super.status, super.name, super.displayName, color);
        return Objects.hash(super.getId(), super.getName(), color);
    }

    public String colorName(Color c) {
        for (Field f : Color.class.getDeclaredFields()) {
            //we want to test only fields of type Color
            if (f.getType().equals(Color.class))
                try {
                    if (f.get(null).equals(c))
                        return f.getName().toLowerCase();
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    // shouldn't not be thrown, but just in case print its stacktrace
                    e.printStackTrace();
                }
        }
        return "";
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
                "id=" + super.getId() +
                ", status=" + super.getStatus() +
                ", name='" + super.getName() + '\'' +
                ", displayName='" + super.getDisplayName() + '\'' +
                ", color=" + colorName(color) +
                "}";
    }

    @Override
    public String DisplayStatus() {
        return "Устройство: шторы" +
                "\t" + super.DisplayStatus().replace("вкл", "открыты").replace("выкл", "закрыты");
    }

}
