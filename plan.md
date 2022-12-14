# План автоматизации тестирования
## Объект тестирования:
 ### Веб-сервис, который предлагает купить тур по определённой цене двумя способами:
 1. Обычная оплата по дебетовой карте.
 2. Выдача кредита по данным банковской карты.
 ### Данные карт
### Разрешенная карта
<table>
   <tbody>
      <tr>
         <th colspan="6">APPROVED</th>
      </tr>
      <tr>
         <th colspan="2" rowspan="2">Номер карты</th>
         <th colspan="2">Срок действия</th>
         <th rowspan="2">Владелец</th>
         <th rowspan="2">CVV</th>
      </tr>
      <tr>
         <td>Месяц</td>
         <td>Год</td>
      </tr>
      <tr>
         <th>4444 4444 4444 4441</th>
         <th colspan="2">Больше или равен текущему</th>
         <th>Больше или равен текущему</th>
         <th>Имя фамилия латиницей</th>
         <th>Число от 000 до 999</th>
      <tr>
    </tbody>
</table> 

### Запрещенная карта
<table>
    <tbody>
      <tr>
         <th colspan="6">DECLINED</th>
      </tr>
      <tr>
         <th colspan="2" rowspan="2">Номер карты</th>
         <th colspan="2">Срок действия</th>
         <th rowspan="2">Владелец</th>
         <th rowspan="2">CVV</th>
      </tr>
      <tr>
         <td>Месяц</td>
         <td>Год</td>
      </tr>
      <tr>
         <th>4444 4444 4444 4442</th>
         <th colspan="2">Бльше или равен текущему</th>
         <th>Бльше или равен текущему</th>
         <th>Имя фамилия латиницей</th>
         <th>Число от 000 до 999</th>
      <tr>
   </tbody>
</table>
 
## Перечень автоматизируемых сценариев
1. Успешная оплата [разрешенной картой](#разрешенная-карта) (APPROVED)
    * Открыть [страницу покупки тура](http://localhost:8080)
    * Нажать `Купить`
    * Заполнить данные [разрешённой карты](#разрешенная-карта) (APPROVED)
    * Нажать `продолжить`
    * Ожидать уведомления об одобрении банком
    * Статус операции в БД (`MySQL` , `Postgres` ) Должен быть "APPROVED"
    * Сумма транзакции должна соответствовать Сумме указанной [странице покупки тура](http://localhost:8080)
2. Отказ в оплате [запрещенной картой](#запрещенная-карта) (DECLINED) 
    * Открыть [страницу покупки тура](http://localhost:8080)
    * Нажать `Купить`
    * Заполнить данные [запрещенной](#разрешенная-карта) карты (DECLINED)
    * Нажать `продолжить`
    * Ожидать уведомления отказа банком
    * Статус операции в БД (`MySQL` , `Postgres` ) Должен быть "APPROVED"
3. Отказ в оплате картой отсутствующей в системе.
    * Открыть [страницу покупки тура](http://localhost:8080)
    * Нажать `Купить`
    * Ввести валидный номер карты. Например `4585697231935162`
    * Ввести имя латиницей. . Например `Ivanov Ivan`.
    * Ввести срок действия карты (Позже текущей даты)
    * Ввести CVV трехзначное число в границах `000...999`
    * Ожидать уведомления отказа банком
4. 







