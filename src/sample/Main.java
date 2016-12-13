package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.*;
import java.util.Arrays;

import static java.lang.System.in;

public class Main extends Application {

    int[][] initialArray = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
    };

    int d1 = 0, d2, d3;

    int[] arrayE = {0, 0, 0, 0, 0, 0};
    int[] arrayP = {0, 0, 0, 0, 0, 0};
    int[] arrayG = {0, 0, 0, 0, 0, 0};

    TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Экспертная система");
        primaryStage.setWidth(300);
        primaryStage.setHeight(275);

        Pane root = new Pane();

        Scene scene = new Scene(root);
        Button btn = new Button();
        Button b = new Button();

        btn.setText("Экспертиза");
        btn.setTranslateX(160);
        btn.setTranslateY(150);

        textArea.setText("Система не обучена");
        textArea.setTranslateX(10);
        textArea.setTranslateY(5);
        textArea.setMaxWidth(280);
        textArea.setMaxHeight(80);
        textArea.setDisable(true);

        b.setText("Обучение");
        b.setMaxWidth(Double.MAX_VALUE);
        b.setTranslateX(30);
        b.setTranslateY(150);
        b.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                newScene(e);
            }
        });

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ExpertScene(event);
                readS();
            }
        });


        root.getChildren().add(btn);
        root.getChildren().add(textArea);
        root.getChildren().addAll(b);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public String firstCalc() {
        int x = 43;
        int y = 15;
        int s = x * y;
        return String.valueOf(s);
    }
    public void newScene(ActionEvent e) {
        Stage window = new Stage();
        window.setTitle("Обучение");
        window.setHeight(280);
        window.setWidth(300);
        Pane study = new Pane();
        Scene scene1 = new Scene(study);

        Button teach = new Button();
        Button closeWindow = new Button();

        final ToggleGroup group = new ToggleGroup();

        RadioButton bird = new RadioButton("Птица");
        bird.setToggleGroup(group);
        bird.setSelected(true);


        RadioButton plane = new RadioButton("Самолёт");
        plane.setToggleGroup(group);

        RadioButton glider = new RadioButton("Планер");
        glider.setToggleGroup(group);

        CheckBox x1 = new CheckBox("Крылья");
        CheckBox x2 = new CheckBox("Хвост");
        CheckBox x3 = new CheckBox("Клюв");
        CheckBox x4 = new CheckBox("Двигатель");
        CheckBox x5 = new CheckBox("Оперение");
        CheckBox x6 = new CheckBox("Шасси");

        teach.setText("Обучить");
        teach.setTranslateX(20);
        teach.setTranslateY(180);

        closeWindow.setText("Закрыть окно");
        closeWindow.setTranslateX(180);
        closeWindow.setTranslateY(180);

        x1.setTranslateX(40);
        x1.setTranslateY(40);

        x2.setTranslateX(40);
        x2.setTranslateY(60);

        x3.setTranslateX(40);
        x3.setTranslateY(80);

        x4.setTranslateX(40);
        x4.setTranslateY(100);

        x5.setTranslateX(40);
        x5.setTranslateY(120);

        x6.setTranslateX(40);
        x6.setTranslateY(140);

        bird.setTranslateX(160);
        bird.setTranslateY(40);

        plane.setTranslateX(160);
        plane.setTranslateY(60);

        glider.setTranslateX(160);
        glider.setTranslateY(80);

        teach.setOnAction(event -> {
            int birdD = (bird.isSelected() ? 1 : 0);
            if(bird.isSelected()) {
                for(int i = 0; i < arrayE.length; i++) {
                    if(x1.isSelected()) { arrayE[0] = 1;}
                    if(x2.isSelected()) { arrayE[1] = 1;}
                    if(x3.isSelected()) { arrayE[2] = 1;}
                    if(x4.isSelected()) { arrayE[3] = 1;}
                    if(x5.isSelected()) { arrayE[4] = 1;}
                    if(x6.isSelected()) { arrayE[5] = 1;}
                }
                System.out.println("Птица:" + Arrays.toString(arrayE));
            }
            if(birdD == 1) {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < initialArray[0].length; j++) {
                        initialArray[0][j] += arrayE[j];
                        if(initialArray[0][j] < -1) {
                            initialArray[0][j] = -1;
                        }
                        if(initialArray[0][j] > 1) {
                            initialArray[0][j] = 1;
                        }
                    }
                }
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < initialArray[1].length; j++) {
                        initialArray[1][j] -= arrayE[j];
                        if(initialArray[1][j] < -1) {
                            initialArray[1][j] = -1;
                        }
                        if(initialArray[1][j] > 1) {
                            initialArray[1][j] = 1;
                        }
                    }
                }
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < initialArray[2].length; j++) {
                        initialArray[2][j] -= arrayE[j];
                        if(initialArray[2][j] < -1) {
                            initialArray[2][j] = -1;
                        }
                        if(initialArray[2][j] > 1) {
                            initialArray[2][j] = 1;
                        }
                    }
                }



                System.out.println("Обучили Птице: " + Arrays.deepToString(initialArray));
            }
            int planeD = (plane.isSelected() ? 1 : 0);
            if(plane.isSelected()) {
                for(int i = 0; i < arrayE.length; i++) {
                    if(x1.isSelected()) { arrayP[0] = 1;}
                    if(x2.isSelected()) { arrayP[1] = 1;}
                    if(x3.isSelected()) { arrayP[2] = 1;}
                    if(x4.isSelected()) { arrayP[3] = 1;}
                    if(x5.isSelected()) { arrayP[4] = 1;}
                    if(x6.isSelected()) { arrayP[5] = 1;}
                }
                System.out.println("Самолёт:" + Arrays.toString(arrayE));
            }
            if(planeD == 1) {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < initialArray[0].length; j++) {
                        initialArray[0][j] -= arrayP[j];
                        if(initialArray[0][j] < -1) {
                            initialArray[0][j] = -1;
                        }
                        if(initialArray[0][j] > 1) {
                            initialArray[0][j] = 1;
                        }
                    }
                }
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < initialArray[1].length; j++) {
                        initialArray[1][j] += arrayP[j];
                        if(initialArray[1][j] < -1) {
                            initialArray[1][j] = -1;
                        }
                        if(initialArray[1][j] > 1) {
                            initialArray[1][j] = 1;
                        }
                    }
                }
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < initialArray[2].length; j++) {
                        initialArray[2][j] -= arrayP[j];
                        if(initialArray[2][j] < -1) {
                            initialArray[2][j] = -1;
                        }
                        if(initialArray[2][j] > 1) {
                            initialArray[2][j] = 1;
                        }
                    }
                }
                System.out.println("Обучили Самолёту: " + Arrays.deepToString(initialArray));
            }
            int gliderD = (glider.isSelected() ? 1 : 0);
            if(glider.isSelected()) {
                for(int i = 0; i < arrayE.length; i++) {
                    if(x1.isSelected()) { arrayG[0] = 1;}
                    if(x2.isSelected()) { arrayG[1] = 1;}
                    if(x3.isSelected()) { arrayG[2] = 1;}
                    if(x4.isSelected()) { arrayG[3] = 1;}
                    if(x5.isSelected()) { arrayG[4] = 1;}
                    if(x6.isSelected()) { arrayG[5] = 1;}
                }
                System.out.println("Планер:" + Arrays.toString(arrayE));
            }
            if(gliderD == 1) {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < initialArray[0].length; j++) {
                        initialArray[0][j] -= arrayG[j];
                        if(initialArray[0][j] < -1) {
                            initialArray[0][j] = -1;
                        }
                        if(initialArray[0][j] > 1) {
                            initialArray[0][j] = 1;
                        }
                    }
                }
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < initialArray[1].length; j++) {
                        initialArray[1][j] -= arrayG[j];
                        if(initialArray[1][j] < -1) {
                            initialArray[1][j] = -1;
                        }
                        if(initialArray[1][j] > 1) {
                            initialArray[1][j] = 1;
                        }
                    }
                }
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < initialArray[2].length; j++) {
                        initialArray[2][j] += arrayG[j];
                        if(initialArray[2][j] < -1) {
                            initialArray[2][j] = -1;
                        }
                        if(initialArray[2][j] > 1) {
                            initialArray[2][j] = 1;
                        }
                    }
                }
                System.out.println("Обучили Планеру:");
                printMatr(initialArray);
            }

            textArea.setText("Система обучена");

        });

        closeWindow.setOnAction(event ->  {
            writeS();
            window.close();
            textArea.setText("Обучена");
        });

        study.getChildren().add(teach);
        study.getChildren().add(closeWindow);
        study.getChildren().add(x1);
        study.getChildren().add(x2);
        study.getChildren().add(x3);
        study.getChildren().add(x4);
        study.getChildren().add(x5);
        study.getChildren().add(x6);
        study.getChildren().add(bird);
        study.getChildren().add(plane);
        study.getChildren().add(glider);
        window.setScene(scene1);
        window.show();
    }


    public void writeS() {
        try {
            // write object to file
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/aleksejermolaev/Desktop/test.ser"));
            out.writeObject(initialArray);
            out.flush();
            out.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readS() {
        System.out.println("Reading file...");

        printMatr(initialArray);
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("/Users/aleksejermolaev/Desktop/test.ser"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            initialArray = (int[][]) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finished reading file");
        printMatr(initialArray);
    }

    public void ExpertScene(ActionEvent e) {
        Stage window = new Stage();
        window.setTitle("Экспертиза");
        window.setHeight(280);
        window.setWidth(300);
        Pane expert = new Pane();
        Scene scene1 = new Scene(expert);

        Button execute = new Button();
        Button closeWindow = new Button();

        final ToggleGroup group = new ToggleGroup();

        CheckBox x1 = new CheckBox("Крылья");
        CheckBox x2 = new CheckBox("Хвост");
        CheckBox x3 = new CheckBox("Клюв");
        CheckBox x4 = new CheckBox("Двигатель");
        CheckBox x5 = new CheckBox("Оперение");
        CheckBox x6 = new CheckBox("Шасси");

        execute.setText("Гипотеза");
        execute.setTranslateX(20);
        execute.setTranslateY(180);

        closeWindow.setText("Закрыть окно");
        closeWindow.setTranslateX(180);
        closeWindow.setTranslateY(180);

        x1.setTranslateX(40);
        x1.setTranslateY(40);

        x2.setTranslateX(40);
        x2.setTranslateY(60);

        x3.setTranslateX(40);
        x3.setTranslateY(80);

        x4.setTranslateX(40);
        x4.setTranslateY(100);

        x5.setTranslateX(40);
        x5.setTranslateY(120);

        x6.setTranslateX(40);
        x6.setTranslateY(140);

        execute.setOnAction(event -> {
            int[] array = {0,0,0,0,0,0};
            int[] tmp = {0,0,0,0,0,0};
            int temp = 0;
            for (int i = 0; i < array.length; i++) {
                if(x1.isSelected()) { array[0] = 1;}
                if(x2.isSelected()) { array[1] = 1;}
                if(x3.isSelected()) { array[2] = 1;}
                if(x4.isSelected()) { array[3] = 1;}
                if(x5.isSelected()) { array[4] = 1;}
                if(x6.isSelected()) { array[5] = 1;}
            }

            for (int j = 0; j < initialArray[0].length; j++) {
                d1 +=initialArray[0][j] * array[j];
            }
            for (int i = 0; i < initialArray[1].length; i++) {
                d2 +=initialArray[1][i] * array[i];
            }
            for (int i = 0; i < initialArray[2].length; i++) {
                d3 +=initialArray[2][i] * array[i];
            }
            if ((d1 > d2) && (d1 > d3)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Гипотеза");
                alert.setHeaderText("Возможно это птица");
                alert.showAndWait();
            }
            if ((d2 > d1) && (d2 > d3)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Гипотеза");
                alert.setHeaderText("Возможно это самолёт");
                alert.showAndWait();
            }
            if ((d3 > d1) && (d3 > d2)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Гипотеза");
                alert.setHeaderText("Возможно это планер");
                alert.showAndWait();
            }
            if((d1 == d2) && (d1 == d3)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Гипотеза");
                alert.setHeaderText("Непонятно");
                alert.showAndWait();
            }
            if((d1 == d2) && (d1 > d3)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Гипотеза");
                alert.setHeaderText("Возможно это птица или самолёт");
                alert.showAndWait();
            }
            if((d1 == d3) && (d1 > d2)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Гипотеза");
                alert.setHeaderText("Возможно это планер или птица");
                alert.showAndWait();
            }
            if((d2 == d3) && (d2 > d1)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Гипотеза");
                alert.setHeaderText("Возможно это планер или самолёт");
                alert.showAndWait();
            }




            array = tmp;
            d1 = temp;
            d2 = temp;
            d3 = temp;
        });

        expert.getChildren().add(execute);
        expert.getChildren().add(closeWindow);
        expert.getChildren().add(x1);
        expert.getChildren().add(x2);
        expert.getChildren().add(x3);
        expert.getChildren().add(x4);
        expert.getChildren().add(x5);
        expert.getChildren().add(x6);
        window.setScene(scene1);
        window.show();


    }
    public void printMatr(int[][] matr) {
        System.out.print("[");
        for(int i = 0; i < matr.length; i++) {
            System.out.print("[");
            for(int j = 0; j < matr[i].length; j++) {
                if (matr[i].length != (j + 1)) {
                    System.out.print(matr[i][j] + ", ");
                } else {
                    System.out.print(matr[i][j]);
                }
            }
            if (matr.length != (i + 1)) {
                System.out.println("],");
            } else {
                System.out.print("]");
            }

        }
        System.out.println("]");
    }

    public void printArr(int[] array) {
        System.out.println("[");
        for (int i = 0; i < array.length; i++) {
            if(array.length != (i + 1)) {
                System.out.print(array[i] + ", ");
            }
            else {
                System.out.print(array[i]);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
