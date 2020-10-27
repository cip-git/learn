//package books.learning.RxJava.chapters._2_Observables_and_Subscribers.coldVsHotObservables.hot;
//
///**
// * A hot Observable is more like a radio station.
// * It broadcasts the same emissions to all Observers at the same time.
// * If an Observer subscribes to a hot Observable,
// * receives some emissions, a
// * nd then another Observer comes in afterwards,
// * that second Observer will have missed those emissions.
// * <p>
// * Just like a radio station, if you tune in too late, you will have missed that song.
// * <p>
// * Logically, hot Observables often represent events rather than finite datasets.
// */
//
//import io.reactivex.Observable;
//import javafx.application.Application;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.control.ToggleButton;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//class L extends Application {
//
//    @Override
//    public void init() throws Exception {
//        super.init();
//    }
//
//    private static <T> Observable<T> valuesOf(ObservableValue<T> fxObservable) {
//        return Observable.create(emitter -> {
//            emitter.onNext(fxObservable.getValue());
//            final ChangeListener<T> listener = (observableValue, prev, current) -> emitter.onNext(current);
//            fxObservable.addListener(listener);
//        });
//    }
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        ToggleButton tb = new ToggleButton("Press me");
//        Label label = new Label();
//
//        Observable<Boolean> selectedState = valuesOf(tb.selectedProperty());
//
//        selectedState.map(s -> s ? "Down" : "Up")
//                .subscribe(label::setText);
//        VBox vBox = new VBox(tb, label);
//        stage.setScene(new Scene(vBox));
//        stage.show();
//    }
//
//    public static void main(String[] args) throws Exception {
//        Stage stage = new Stage();
//
//        L l = new L();
//        l.init();
//        l.start(stage);
//    }
//}
