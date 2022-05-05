import java.awt.*;

/** Урок 7: Object и Generics
 * Практическое задание №9 - Object, Generics
 * Придумать индивидуальное семейство классов, которое будет
 * использовать обобщение. (Минимум 2 класса и 1 интерфейс)
 * В практике должно быть ограничение обобщения по интерфейсу.
 * В Main классе должно быть продемонстрировано, что в аргумент
 * конструктора класса можно передавать объекты разных классов,
 * которые реализуют данный интерфейс.
 * Переопределить методы класса Object.
 * Продемонстрировать функционал классов.
 */
public class Main {
    public static void main(String[] args) {
        Lighting<String, Integer> L1 = new Lighting<>("1",0, "L1", "Гостиная", Colour.COLD );
        L1.OnOff(1); // вкл. свет в гостиной
        Lighting<String, Integer> L2 = new Lighting<>("2",null, "L2", "Кухня", Colour.NEUTRAL);
        Lighting<Integer, String> L3 = new Lighting<>(3,"Вкл", "L3", "Спальня", Colour.WARM);
        Lighting<Integer, String> L4 = new Lighting<>(new Device<>(4, null, "L3", "Прихожая"));
        L3.OnOff(0); // выкл. свет в спальне
        Heating<Integer, String> H11 = new Heating<>(11,"Выкл", "H11", "Газовый котел", 40);
        H11.setTemperatureCurrent(15); // текущая температура воды в котле
        H11.setTemperatureWarm(60); // установим темп. нагревания до 60 градусов
        H11.OnOff(1); // вкл котел на нагрев воды до 60 градусов
        Heating<Integer, String> H12 = new Heating<>(12,"Выкл", "H12", "Электр. камин", 20);
        H12.setTemperatureCurrent(22); // текущая температура помещения
        H12.OnOff(1); // вкл камин на нагрев помещения до 20 градусов
        Сurtain<String, Integer> C21 = new Сurtain<>("21", 1, "C21", "Гсстиная", Color.BLUE);
        Сurtain<String, Integer> C22 = new Сurtain<>("22", 1, "C21", "Спальня", Color.YELLOW);
        C22.OnOff(0); //закрыть шторы в спальне
        Device[] devices = {L1, L2, L3, L4, H11, H12, C21, C22};
        // выведем состония устройств
        System.out.println("\r\nСостояния\r\n".toUpperCase());
        for (Device item: devices) {
            System.out.println(item.DisplayStatus());
        }
        // выведем характеристики устройств
        System.out.println("\r\nХарактеристики\r\n".toUpperCase());
        for (Device item: devices) {
            System.out.println(item.hashCode() + "\t" + item.toString());
        }
    }
}
