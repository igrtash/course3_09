/** Интерфейс управления устройствами умного дома
 *
 */
public interface IManageDevice {
    /** Включение/выключение устройства
     * @param action 1-On, 0-Off
     */
    public void OnOff(int action);

    /** Отображение текущего состояния устройства
     * @param obj устройство умного дома
     * @return текущий статус
     */
    public String DisplayStatus();

}
