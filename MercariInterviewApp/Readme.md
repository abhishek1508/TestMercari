Architecture
------------

The app follows ModelViewPresenter architecture. MVP architecture has been followed because of the following reasons.

1. Clear separation of responsibilities
   UI - responsible for showing the view.
   Presenter - responsible for reating to UI events
   Model - responsible for business logic and state recording.
2. Easy to test
3. High code reusability.
4. Flexible and adaptable.

The app uses Dagger for dependency injection. Each module maintains its own scope.
Only the App Module has a scope in the entire app and is defined by AppScope.
Any component depending on AppScope can be injected anywhere inside the entire app anytime.

The app makes use of RxJava to some extent b/c there was not much use of RxJava in the app as per my understanding.

The app consists of a home package which has a subpackage of mvp.
This subpackage consists of a Contract, Interactor and Presenter. When the app starts HomeActivity is triggered.
It sets up the dagger components first and then calls the method in the presenter to load the json file from the assets.
Once the interactor loads the json file it then parses it. Once parsed, the list of items is then passed to the view
to display it in a recycler view.

The recycler view has a layout defined and populates each item respectively. It checks the item.status to see if the
status reflects "sold_out". Depending on the value it shows/hides the sold image in each item.

To add retrofit to be able to get the data from network it is as easy as:

1. Replace @Component(modules = AppModule.class) with @Component(modules = {AppModule.class, NetworkModule.class}) in AppComponent.java file
2. Add this line here

   DaggerAppComponent                                                                  DaggerAppComponent
                .builder()                                                                      .builder()
                .appModule(new AppModule(this))    -----> changes to ------>                    .appModule(new AppModule(this)).networkModule(new NetworkModule("baseUrl"))
                .build();                                                                       .build()

3. Add Retrofit retrofit(); in AppComponent.java
4. Build the app.
5. Now just Inject Retrofit in HomeActivity.java --> @Inject Retrofit retrofit;