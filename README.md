# CryptoList trainee test
Приложение для вывода списка криптовалют с сервиса CoinGecko

# План

Поскольку приложение простое и не требует каких то особых возможностей к расширению, у нас будет 3 банальных слоя: ui, viewmodel и data. Можно пойти с 2х строн: сначала ui с моком data или наоборот. 

Для ui возьмём Jetpack compose, так как это уже стандарт, активно продвигаемый гуглом.
Чтобы упростить себе жизнь, для подгрузки изображений возьмем Coil. Он тянет OkHTTP, который нам и так нужен для Retrofit, потому он не добавит много веса.
Остальной стек будет Классическим, так как он самый надёжный и простой: Retrofit, Coroutines, LiveData.

Я люблю чтобы все выводилось красиво, потому начну с ui:

1. Подключить нужные библиотеки
2. Прикинуть навигацию (NavHost’ов будет за глаза)
3. Сделать все ui компоненты
4. Собрать все вместе
5. Пулл рефреш делается через библиотеку и 1 доп. состояние, что очень просто и не требует затрат.

data:

1. В postman понять как работеат api
2. Подключить нужные библиотеки (Okhttp, Retrofit должно хватить)
3. Написать сущности Api и GET функции обращения к ним, 
4. Изображения будем докачивать в процессе использования, поскольку они не очень важны для вывода списка и подробной информации.
5. Прописать потоки данных через viewmodel, чтобы связать data и ui вместе.

С учётом фикса багов на ui и data слой уйдет по ~10 часов. Потом умножим эту цифру на 2 и получим 2 дня работы без перерывов.