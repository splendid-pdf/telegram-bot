### Tasks

* Календарь событий: c текущей даты, под каждым ивентом инлайн кнопка на ссылку Google-Meet, Добавить в избранное

* Нарисовать инлайн для создания ивента: вводим название, вводим описание, вводим дата и время, ссылка на Google-Meet

* Профиль: добавить локацию, изменить роль

* Профиль: избранные события, мои события

* Избранные события: каждое событие с инлайн кнопками Удалить с избранных

* Мои события: изменение, удаление, (приглашение)

# Splendid-pdf telegram-bot

Настройка Webhook:
  1) Скачиваем *https://ngrok.com/download* и запускам его
  2) Прописываем комманду **ngrok http {port}**
  3) Проходим по адресу *https://api.telegram.org/bot[TOKEN]/setWebhook?url=[URL]* заполнив токеном бота и адресом, который получили во втором шаге

### Команды бота:
* */start* - запуск бота

### Использованные паттерны проектирования GoF:

* **Command Pattern**

![img.png](img.png)

* class Invoker(CommandContext) >>> 
* interface Command(MainMenuCommand) >>> 
* class Concrete Command(class implement interface MainMenuCommand) >>> 
* class Receiver(InlineKeyboard)