package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    //Basic Score Metrics
        //Exploitability Metrics
    @FXML
    private ChoiceBox<String> AV;
    private ObservableList<String> AVList = FXCollections.observableArrayList("Local (L)", "Adjacent network (A)", "Network (N)");
    @FXML
    private ChoiceBox<String> AC;
    private ObservableList<String> ACList = FXCollections.observableArrayList("High (H)", "Medium (M)", "Low (L)");
    @FXML
    private ChoiceBox<String> Au;
    private ObservableList<String> AuList = FXCollections.observableArrayList("Multiple (M)", "Single (S)", "None (N)");
        //Impact Metrics
    @FXML
    private ChoiceBox<String> C;
    private ObservableList<String> CList = FXCollections.observableArrayList("None (N)", "Partial (P)", "Complete (C)");
    @FXML
    private ChoiceBox<String> I;
    private ObservableList<String> IList = FXCollections.observableArrayList("None (N)", "Partial (P)", "Complete (C)");
    @FXML
    private ChoiceBox<String> A;
    private ObservableList<String> AList = FXCollections.observableArrayList("None (N)", "Partial (P)", "Complete (C)");

    //Temporal Score Metrics
    @FXML
    private ChoiceBox<String> E;
    private ObservableList<String> EList = FXCollections.observableArrayList("Not Defined (ND)", "Unproven that exploit exists (E)", "Proof of concept code (POC)", "Functional exploit exists (F)", "High (H)");
    @FXML
    private ChoiceBox<String> RL;
    private ObservableList<String> RLList = FXCollections.observableArrayList("Not Defined (ND)", "Official fix (OF)", "Temporary fix (TF)", "Workaround (W)", "Unavailable (U)");
    @FXML
    private ChoiceBox<String> RC;
    private ObservableList<String> RCList = FXCollections.observableArrayList("Not Defined (ND)", "Unconfirmed (UC)", "Uncorroborated (UR)", "Confirmed (C)");

    //Environmental Score Metrics
        //General Modifiers
    @FXML
    private ChoiceBox<String> CDP;
    private ObservableList<String> CDPList = FXCollections.observableArrayList("Not Defined (ND)", "None (N)", "Low (light loss) (L)", "Low-Medium (LM)", "Medium-High (MH)", "High (catastrophic loss) (H)");
    @FXML
    private ChoiceBox<String> TD;
    private ObservableList<String> TDList = FXCollections.observableArrayList("Not Defined (ND)", "None [0%] (N)", "Low [0-25%] (L)", "Medium [26-75%] (M)", "High [76-100%] (H)");
        //Impact Subscore Modifiers
    @FXML
    private ChoiceBox<String> CR;
    private ObservableList<String> CRList = FXCollections.observableArrayList("Not Defined (ND)", "Low (L)", "Medium (M)", "High (H)");
    @FXML
    private ChoiceBox<String> IR;
    private ObservableList<String> IRList = FXCollections.observableArrayList("Not Defined (ND)", "Low (L)", "Medium (M)", "High (H)");
    @FXML
    private ChoiceBox<String> AR;
    private ObservableList<String> ARList = FXCollections.observableArrayList("Not Defined (ND)", "Low (L)", "Medium (M)", "High (H)");

    //v3
    //Base Score Metrics
    //Exploitability Metrics
    @FXML
    private ChoiceBox<String> AV3;
    private ObservableList<String> AV3List = FXCollections.observableArrayList("Network (N)", "Adjacent network (A)", "Local (L)", "Physical (P)");
    @FXML
    private ChoiceBox<String> AC3;
    private ObservableList<String> AC3List = FXCollections.observableArrayList( "Low (L)", "High (H)");
    @FXML
    private ChoiceBox<String> PR3;
    private ObservableList<String> PR3List = FXCollections.observableArrayList("None (N)", "Low (L)", "High (H)");
    @FXML
    private ChoiceBox<String> UI3;
    private ObservableList<String> UI3List = FXCollections.observableArrayList("None (N)", "Required (R)");
    @FXML
    private ChoiceBox<String> S3;
    private ObservableList<String> S3List = FXCollections.observableArrayList("Unchanged (U)", "Changed (C)");
    //Impact Metrics
    @FXML
    private ChoiceBox<String> C3;
    private ObservableList<String> C3List = FXCollections.observableArrayList("None (N)", "Low (L)", "High (H)");
    @FXML
    private ChoiceBox<String> I3;
    private ObservableList<String> I3List = FXCollections.observableArrayList("None (N)", "Low (L)", "High (H)");
    @FXML
    private ChoiceBox<String> A3;
    private ObservableList<String> A3List = FXCollections.observableArrayList("None (N)", "Low (L)", "High (H)");

    //Temporal Score Metrics
    @FXML
    private ChoiceBox<String> E3;
    private ObservableList<String> E3List = FXCollections.observableArrayList("Not Defined (X)", "Unproven that exploit exists (U)", "Proof of concept code (P)", "Functional exploit exists (F)", "High (H)");
    @FXML
    private ChoiceBox<String> RL3;
    private ObservableList<String> RL3List = FXCollections.observableArrayList("Not Defined (X)", "Official fix (O)", "Temporary fix (T)", "Workaround (W)", "Unavailable (U)");
    @FXML
    private ChoiceBox<String> RC3;
    private ObservableList<String> RC3List = FXCollections.observableArrayList("Not Defined (X)", "Unknown (U)", "Reasonable (R)", "Confirmed (C)");

    //Environmental Score Metrics
    //Base Modifiers
    @FXML
    private ChoiceBox<String> AV33;
    private ObservableList<String> AV33List = FXCollections.observableArrayList("Not Defined (X)", "Network (N)", "Adjacent network (A)", "Local (L)", "Physical (P)");
    @FXML
    private ChoiceBox<String> AC33;
    private ObservableList<String> AC33List = FXCollections.observableArrayList( "Not Defined (X)", "Low (L)", "High (H)");
    @FXML
    private ChoiceBox<String> PR33;
    private ObservableList<String> PR33List = FXCollections.observableArrayList("Not Defined (X)", "None (N)", "Low (L)", "High (H)");
    @FXML
    private ChoiceBox<String> UI33;
    private ObservableList<String> UI33List = FXCollections.observableArrayList("Not Defined (X)", "None (N)", "Required (R)");
    @FXML
    private ChoiceBox<String> S33;
    private ObservableList<String> S33List = FXCollections.observableArrayList("Not Defined (X)", "Unchanged (U)", "Changed (C)");
    //Impact Metrics
    @FXML
    private ChoiceBox<String> C33;
    private ObservableList<String> C33List = FXCollections.observableArrayList("Not Defined (X)", "None (N)", "Low (L)", "High (H)");
    @FXML
    private ChoiceBox<String> I33;
    private ObservableList<String> I33List = FXCollections.observableArrayList("Not Defined (X)", "None (N)", "Low (L)", "High (H)");
    @FXML
    private ChoiceBox<String> A33;
    private ObservableList<String> A33List = FXCollections.observableArrayList("Not Defined (X)", "None (N)", "Low (L)", "High (H)");
    // Impact Subscore Modifiers
    @FXML
    private ChoiceBox<String> CR3;
    private ObservableList<String> CR3List = FXCollections.observableArrayList("Not Defined (X)", "Low (L)", "Medium (M)", "High (H)");
    @FXML
    private ChoiceBox<String> IR3;
    private ObservableList<String> IR3List = FXCollections.observableArrayList("Not Defined (X)", "Low (L)", "Medium (M)", "High (H)");
    @FXML
    private ChoiceBox<String> AR3;
    private ObservableList<String> AR3List = FXCollections.observableArrayList("Not Defined (X)", "Low (L)", "Medium (M)", "High (H)");

    @FXML
    private Label CVSSLabel;
    @FXML
    private Label scoreMetricsLabel;
    @FXML
    private HBox basicScoreMetricsHBox;
    @FXML
    private HBox temporalScoreMetricsHBox;
    @FXML
    private HBox environmentalScoreMetricsHBox;
    @FXML
    private HBox basicScoreMetrics3HBox;
    @FXML
    private HBox temporalScoreMetrics3HBox;
    @FXML
    private HBox environmentalScoreMetrics3HBox;
    @FXML
    private Label chooseButtonLabel;
    @FXML
    private Button CVSSv2Button;
    @FXML
    private Button CVSSv3Button;
    @FXML
    private Button backButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button calculateButton;
    @FXML
    private Button returnButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private HBox versionButtons;
    @FXML
    private HBox buttonsHBox;
    @FXML
    private HBox scoresHBox;
    @FXML
    private Label basicScoreLabel;
    @FXML
    private Label impactSubcoreLabel;
    @FXML
    private Label exploitabilitySubcoreLabel;
    @FXML
    private Label temporalScoreLabel;
    @FXML
    private Label environmentalScoreLabel;
    @FXML
    private Label modifiedSubscoreLabel;
    @FXML
    private Label overallScoreLabel;

    List<HBox> hBoxes;
    List<String> metrics;

    int index = 0;

    @FXML
    private void initialize() {
        AV.setItems(AVList);
        AC.setItems(ACList);
        Au.setItems(AuList);
        C.setItems(CList);
        I.setItems(IList);
        A.setItems(AList);
        E.setItems(EList);
        RL.setItems(RLList);
        RC.setItems(RCList);
        CDP.setItems(CDPList);
        TD.setItems(TDList);
        CR.setItems(CRList);
        IR.setItems(IRList);
        AR.setItems(ARList);
        AV3.setItems(AV3List);
        AC3.setItems(AC3List);
        PR3.setItems(PR3List);
        UI3.setItems(UI3List);
        S3.setItems(S3List);
        C3.setItems(C3List);
        I3.setItems(I3List);
        A3.setItems(A3List);
        E3.setItems(E3List);
        RL3.setItems(RL3List);
        RC3.setItems(RC3List);
        AV33.setItems(AV33List);
        AC33.setItems(AC33List);
        PR33.setItems(PR33List);
        UI33.setItems(UI33List);
        S33.setItems(S33List);
        C33.setItems(C33List);
        I33.setItems(I33List);
        A33.setItems(A33List);
        CR3.setItems(CR3List);
        IR3.setItems(IR3List);
        AR3.setItems(AR3List);

        metrics = new ArrayList<>();
        metrics.add("Base Score Metrics");
        metrics.add("Temporal Score Metrics");
        metrics.add("Environmental Score Metrics");

        CVSSv2Button.setOnMouseClicked(event -> {
            hBoxes = new ArrayList<>();
            hBoxes.add(basicScoreMetricsHBox);
            hBoxes.add(temporalScoreMetricsHBox);
            hBoxes.add(environmentalScoreMetricsHBox);
            CVSSLabel.setText("CVSS v2");
            openMetricsMenu();
        });

        CVSSv3Button.setOnMouseClicked(event -> {
            hBoxes = new ArrayList<>();
            hBoxes.add(basicScoreMetrics3HBox);
            hBoxes.add(temporalScoreMetrics3HBox);
            hBoxes.add(environmentalScoreMetrics3HBox);
            CVSSLabel.setText("CVSS v3");
            openMetricsMenu();
        });

        returnButton.setOnMouseClicked(event -> {
            chooseButtonLabel.setVisible(true);
            versionButtons.setVisible(true);
            returnButton.setVisible(false);
            CVSSLabel.setVisible(false);
            anchorPane.setVisible(false);
            buttonsHBox.setVisible(false);
            backButton.setDisable(false);
            hBoxes.get(index).setVisible(false);
            scoreMetricsLabel.setVisible(false);
            scoresHBox.setVisible(false);
            index = 0;
        });

        nextButton.setOnMouseClicked(event -> {
            hBoxes.get(index).setVisible(false);
            index++;
            hBoxes.get(index).setVisible(true);
            if (index == 2){
                nextButton.setDisable(true);
            }
            backButton.setDisable(false);
            scoreMetricsLabel.setText(metrics.get(index));
        });

        backButton.setOnMouseClicked(event -> {
            hBoxes.get(index).setVisible(false);
            index--;
            hBoxes.get(index).setVisible(true);
            if (index == 0){
                backButton.setDisable(true);
            }
            nextButton.setDisable(false);
            scoreMetricsLabel.setText(metrics.get(index));
        });

        calculateButton.setOnMouseClicked(event -> {
            if(CVSSLabel.getText().equals("CVSS v2")){
                calculate();
            }
            if(CVSSLabel.getText().equals("CVSS v3")){
                calculate3();
            }
            scoresHBox.setVisible(true);
            hBoxes.get(index).setVisible(false);
            buttonsHBox.setVisible(false);
            scoreMetricsLabel.setText("Scores");
        });
    }

    private void openMetricsMenu(){
        chooseButtonLabel.setVisible(false);
        versionButtons.setVisible(false);
        returnButton.setVisible(true);
        CVSSLabel.setVisible(true);
        anchorPane.setVisible(true);
        buttonsHBox.setVisible(true);
        backButton.setDisable(true);
        nextButton.setDisable(false);
        hBoxes.get(index).setVisible(true);
        scoreMetricsLabel.setVisible(true);
        scoreMetricsLabel.setText(metrics.get(index));
        AV.setValue(null);
        AC.setValue(null);
        Au.setValue(null);
        C.setValue(null);
        I.setValue(null);
        A.setValue(null);
        E.setValue("Not Defined (ND)");
        RL.setValue("Not Defined (ND)");
        RC.setValue("Not Defined (ND)");
        CDP.setValue("Not Defined (ND)");
        TD.setValue("Not Defined (ND)");
        CR.setValue("Not Defined (ND)");
        IR.setValue("Not Defined (ND)");
        AR.setValue("Not Defined (ND)");
        AV3.setValue(null);
        AC3.setValue(null);
        PR3.setValue(null);
        UI3.setValue(null);
        S3.setValue(null);
        C3.setValue(null);
        I3.setValue(null);
        A3.setValue(null);
        E3.setValue("Not Defined (X)");
        RL3.setValue("Not Defined (X)");
        RC3.setValue("Not Defined (X)");
        AV33.setValue("Not Defined (X)");
        AC33.setValue("Not Defined (X)");
        PR33.setValue("Not Defined (X)");
        UI33.setValue("Not Defined (X)");
        S33.setValue("Not Defined (X)");
        C33.setValue("Not Defined (X)");
        I33.setValue("Not Defined (X)");
        A33.setValue("Not Defined (X)");
        CR3.setValue("Not Defined (X)");
        IR3.setValue("Not Defined (X)");
        AR3.setValue("Not Defined (X)");
    }

    private void calculate(){
        basicScoreLabel.setText("NA");
        impactSubcoreLabel.setText("NA");
        exploitabilitySubcoreLabel.setText("NA");
        temporalScoreLabel.setText("NA");
        environmentalScoreLabel.setText("NA");
        modifiedSubscoreLabel.setText("NA");
        overallScoreLabel.setText("NA");
        double av = 0;
        double ac = 0;
        double au = 0;
        double c = 0;
        double i = 0;
        double a = 0;
        double e = 1;
        double rl = 1;
        double rc = 1;
        double cdp = 0;
        double td = 0;
        double cr = 0;
        double ir = 0;
        double ar = 0;
        boolean baseScoreBool = true;
        boolean temporalScoreBool = true;
        boolean environmentalScoreBool = true;

        if(AV.getValue() != null && AC.getValue() != null && Au.getValue() != null && C.getValue() != null && I.getValue() != null && A.getValue() != null){
            switch (AV.getValue()){
                case "Local (L)":
                    av = 0.395;
                    break;
                case "Adjacent network (A)":
                    av = 0.646;
                    break;
                case "Network (N)":
                    av = 1;
                    break;
            }
            switch (AC.getValue()){
                case "High (H)":
                    ac = 0.35;
                    break;
                case "Medium (M)":
                    ac = 0.61;
                    break;
                case "Low (L)":
                    ac = 0.71;
                    break;
            }
            switch (Au.getValue()){
                case "Multiple (M)":
                    au = 0.45;
                    break;
                case "Single (S)":
                    au = 0.56;
                    break;
                case "None (N)":
                    au = 0.704;
                    break;
            }
            switch (C.getValue()){
                case "None (N)":
                    c = 0;
                    break;
                case "Partial (P)":
                    c = 0.275;
                    break;
                case "Complete (C)":
                    c = 0.66;
                    break;
            }
            switch (I.getValue()){
                case "None (N)":
                    i = 0;
                    break;
                case "Partial (P)":
                    i = 0.275;
                    break;
                case "Complete (C)":
                    i = 0.66;
                    break;
            }
            switch (A.getValue()){
                case "None (N)":
                    a = 0;
                    break;
                case "Partial (P)":
                    a = 0.275;
                    break;
                case "Complete (C)":
                    a = 0.66;
                    break;
            }
        } else {
            baseScoreBool = false;
        }

        switch (E.getValue()){
            case "Not Defined (ND)":
            case "High (H)":
                e = 1;
                break;
            case "Unproven that exploit exists (E)":
                e = 0.85;
                break;
            case "Proof of concept code (POC)":
                e = 0.9;
                break;
            case "Functional exploit exists (F)":
                e = 0.95;
                break;
        }
        switch (RL.getValue()){
            case "Not Defined (ND)":
            case "Unavailable (U)":
                rl = 1;
                break;
            case "Official fix (OF)":
                rl = 0.87;
                break;
            case "Temporary fix (TF)":
                rl = 0.9;
                break;
            case "Workaround (W)":
                rl = 0.95;
                break;
        }
        switch (RC.getValue()){
            case "Not Defined (ND)":
            case "Confirmed (C)":
                rc = 1;
                break;
            case "Unconfirmed (UC)":
                rc = 0.9;
                break;
            case "Uncorroborated (UR)":
                rc = 0.95;
                break;
        }

        if(E.getValue().equals("Not Defined (ND)") && RL.getValue().equals("Not Defined (ND)") && RC.getValue().equals("Not Defined (ND)")){
            temporalScoreBool = false;
        }

        switch (CDP.getValue()){
            case "Not Defined (ND)":
            case "None (N)":
                cdp = 0;
                break;
            case "Low (light loss) (L)":
                cdp = 0.1;
                break;
            case "Low-Medium (LM)":
                cdp = 0.3;
                break;
            case "Medium-High (MH)":
                cdp = 0.4;
                break;
            case "High (catastrophic loss) (H)":
                cdp = 0.5;
                break;
        }
        switch (TD.getValue()){
            case "Not Defined (ND)":
            case "High [76-100%] (H)":
                td = 1;
                break;
            case "None [0%] (N)":
                td = 0;
                break;
            case "Low [0-25%] (L)":
                td = 0.25;
                break;
            case "Medium [26-75%] (M)":
                td = 0.75;
                break;
        }
        switch (CR.getValue()){
            case "Not Defined (ND)":
            case "Medium (M)":
                cr = 1;
                break;
            case "Low (L)":
                cr = 0.5;
                break;
            case "High (H)":
                cr = 1.51;
                break;
        }
        switch (IR.getValue()){
            case "Not Defined (ND)":
            case "Medium (M)":
                ir = 1;
                break;
            case "Low (L)":
                ir = 0.5;
                break;
            case "High (H)":
                ir = 1.51;
                break;
        }
        switch (AR.getValue()){
            case "Not Defined (ND)":
            case "Medium (M)":
                ar = 1;
                break;
            case "Low (L)":
                ar = 0.5;
                break;
            case "High (H)":
                ar = 1.51;
                break;
        }
        if(CDP.getValue().equals("Not Defined (ND)") && TD.getValue().equals("Not Defined (ND)") && CR.getValue().equals("Not Defined (ND)") && IR.getValue().equals("Not Defined (ND)") && AR.getValue().equals("Not Defined (ND)")){
            environmentalScoreBool = false;
        }


        if(baseScoreBool){
            double impact = 10.41 * (1 - (1 - c) * (1 - i) * (1 - a));
            double exploitability = 20 * av * ac * au;
            double fImpact = 1.176;
            if(impact == 0){
                fImpact = 0;
            }
            double baseScore = Math.round((0.6 * impact + 0.4 * exploitability - 1.5) * fImpact * 10) / 10.0;
            basicScoreLabel.setText(String.valueOf(baseScore));
            impactSubcoreLabel.setText(String.valueOf(Math.round(impact * 10)  / 10.0));
            exploitabilitySubcoreLabel.setText(String.valueOf(Math.round(exploitability * 10)  / 10.0));
            overallScoreLabel.setText(String.valueOf(baseScore));
            if(environmentalScoreBool){
                double adjustedImpact = Math.min(10.0, 10.41 * (1 - (1 - c * cr) * (1 - i * ir) * (1 - a * ar)));
                double adjustedBaseScore = (0.6 * adjustedImpact + 0.4 * exploitability - 1.5) * fImpact;
                double adjustedTemporal = adjustedBaseScore * e * rl * rc;
                double environmentalScore = Math.round((adjustedTemporal + (10 - adjustedTemporal) * cdp) * td * 10) / 10.0;
                environmentalScoreLabel.setText(String.valueOf(environmentalScore));
                modifiedSubscoreLabel.setText(String.valueOf(Math.round(adjustedImpact * 10)  / 10.0));
                overallScoreLabel.setText(String.valueOf(environmentalScore));
            }

            if(temporalScoreBool){
                double temporalScore = Math.round(baseScore * e * rl * rc * 10) / 10.0;
                temporalScoreLabel.setText(String.valueOf(temporalScore));
                overallScoreLabel.setText(String.valueOf(temporalScore));
            }
        } else {
            basicScoreLabel.setText("NA");
            impactSubcoreLabel.setText("NA");
            exploitabilitySubcoreLabel.setText("NA");
            temporalScoreLabel.setText("NA");
            environmentalScoreLabel.setText("NA");
            modifiedSubscoreLabel.setText("NA");
            overallScoreLabel.setText("NA");
        }
    }

    private void calculate3(){
        basicScoreLabel.setText("NA");
        impactSubcoreLabel.setText("NA");
        exploitabilitySubcoreLabel.setText("NA");
        temporalScoreLabel.setText("NA");
        environmentalScoreLabel.setText("NA");
        modifiedSubscoreLabel.setText("NA");
        overallScoreLabel.setText("NA");
        double av3 = 0;
        double ac3 = 0;
        double pr3 = 0;
        double ui3 = 0;
        double s3 = 0;
        double c3 = 0;
        double i3 = 0;
        double a3 = 0;
        double e3 = 1;
        double rl3 = 1;
        double rc3 = 1;
        double av33 = 0;
        double ac33 = 0;
        double pr33 = 0;
        double ui33 = 0;
        double s33 = 0;
        double c33 = 0;
        double i33 = 0;
        double a33 = 0;
        double cr3 = 0;
        double ir3 = 0;
        double ar3 = 0;
        boolean baseScoreBool = true;
        boolean temporalScoreBool = true;
        boolean environmentalScoreBool = true;

        if(AV3.getValue() != null && AC3.getValue() != null && PR3.getValue() != null && UI3.getValue() != null && S3.getValue() != null && C3.getValue() != null && I3.getValue() != null && A3.getValue() != null){
            switch (AV3.getValue()){
                case"Network (N)":
                    av3 = 0.85;
                    break;
                case "Adjacent network (A)":
                    av3 = 0.62;
                    break;
                case "Local (L)":
                    av3 = 0.55;
                    break;
                case "Physical (P)":
                    av3 = 0.2;
                    break;
            }
            switch (AC3.getValue()){
                case "Low (L)":
                    ac3 = 0.77;
                    break;
                case "High (H)":
                    ac3 = 0.44;
                    break;
            }
            switch (S3.getValue()){
                case "Unchanged (U)":
                    s3 = 0;
                    break;
                case "Changed (C)":
                    s3 = 1;
                    break;
            }
            switch (PR3.getValue()){
                case "None (N)":
                    pr3 = 0.85;
                    break;
                case "Low (L)":
                    if(s3 == 1){
                        pr3 = 0.68;
                    } else {
                        pr3 = 0.62;
                    }
                    break;
                case "High (H)":
                    if(s3 == 1){
                        pr3 = 0.5;
                    } else {
                        pr3 = 0.27;
                    }
                    break;
            }
            switch (UI3.getValue()){
                case "None (N)":
                    ui3 = 0.85;
                    break;
                case "Required (R)":
                    ui3 = 0.62;
                    break;
            }
            switch (C3.getValue()){
                case "None (N)":
                    c3 = 0;
                    break;
                case "Low (L)":
                    c3 = 0.22;
                    break;
                case "High (H)":
                    c3 = 0.56;
                    break;
            }
            switch (I3.getValue()){
                case "None (N)":
                    i3 = 0;
                    break;
                case "Low (L)":
                    i3 = 0.22;
                    break;
                case "High (H)":
                    i3 = 0.56;
                    break;
            }
            switch (A3.getValue()){
                case "None (N)":
                    a3 = 0;
                    break;
                case "Low (L)":
                    a3 = 0.22;
                    break;
                case "High (H)":
                    a3 = 0.56;
                    break;
            }
        } else {
            baseScoreBool = false;
        }

        switch (E3.getValue()){
            case "Not Defined (X)":
            case "High (H)":
                e3 = 1;
                break;
            case "Unproven that exploit exists (U)":
                e3 = 0.91;
                break;
            case "Proof of concept code (P)":
                e3 = 0.94;
                break;
            case "Functional exploit exists (F)":
                e3 = 0.97;
                break;
        }
        switch (RL3.getValue()){
            case "Not Defined (X)":
            case "Unavailable (U)":
                rl3 = 1;
                break;
            case "Official fix (O)":
                rl3 = 0.95;
                break;
            case "Temporary fix (T)":
                rl3 = 0.96;
                break;
            case "Workaround (W)":
                rl3 = 0.97;
                break;
        }
        switch (RC3.getValue()){
            case "Not Defined (X)":
            case "Confirmed (C)":
                rc3 = 1;
                break;
            case "Unknown (U)":
                rc3 = 0.92;
                break;
            case "Reasonable (R)":
                rc3 = 0.96;
                break;
        }

        if(E3.getValue().equals("Not Defined (X)") && RL3.getValue().equals("Not Defined (X)") && RC3.getValue().equals("Not Defined (X)")){
            temporalScoreBool = false;
        }

        switch (AV33.getValue()){
            case "Not Defined (X)":
                av33 = av3;
                break;
            case"Network (N)":
                av33 = 0.85;
                break;
            case "Adjacent network (A)":
                av33 = 0.62;
                break;
            case "Local (L)":
                av33 = 0.55;
                break;
            case "Physical (P)":
                av33 = 0.2;
                break;
        }
        switch (AC33.getValue()){
            case "Not Defined (X)":
                ac33 = ac3;
                break;
            case "Low (L)":
                ac33 = 0.77;
                break;
            case "High (H)":
                ac33 = 0.44;
                break;
        }
        switch (S33.getValue()){
            case "Not Defined (X)":
                s33 = s3;
                break;
            case "Unchanged (U)":
                s33 = 0;
                break;
            case "Changed (C)":
                s33 = 1;
                break;
        }
        switch (PR33.getValue()){
            case "Not Defined (X)":
                pr33 = pr3;
                break;
            case "None (N)":
                pr33 = 0.85;
                break;
            case "Low (L)":
                if(s33 == 1){
                    pr33 = 0.68;
                } else {
                    pr33 = 0.62;
                }
                break;
            case "High (H)":
                if(s33 == 1){
                    pr33 = 0.5;
                } else {
                    pr33 = 0.27;
                }
                break;
        }
        switch (UI33.getValue()){
            case "Not Defined (X)":
                ui33 = ui3;
                break;
            case "None (N)":
                ui33 = 0.85;
                break;
            case "Required (R)":
                ui33 = 0.62;
                break;
        }
        switch (C33.getValue()){
            case "Not Defined (X)":
                c33 = c3;
                break;
            case "None (N)":
                c33 = 0;
                break;
            case "Low (L)":
                c33 = 0.22;
                break;
            case "High (H)":
                c33 = 0.56;
                break;
        }
        switch (I33.getValue()){
            case "Not Defined (X)":
                i33 = i3;
                break;
            case "None (N)":
                i33 = 0;
                break;
            case "Low (L)":
                i33 = 0.22;
                break;
            case "High (H)":
                i33 = 0.56;
                break;
        }
        switch (A33.getValue()){
            case "Not Defined (X)":
                a33 = a3;
                break;
            case "None (N)":
                a33 = 0;
                break;
            case "Low (L)":
                a33 = 0.22;
                break;
            case "High (H)":
                a33 = 0.56;
                break;
        }
        switch (CR3.getValue()){
            case "Not Defined (X)":
            case "Medium (M)":
                cr3 = 1;
                break;
            case "Low (L)":
                cr3 = 0.5;
                break;
            case "High (H)":
                cr3 = 1.5;
                break;
        }
        switch (IR3.getValue()){
            case "Not Defined (X)":
            case "Medium (M)":
                ir3 = 1;
                break;
            case "Low (L)":
                ir3 = 0.5;
                break;
            case "High (H)":
                ir3 = 1.5;
                break;
        }
        switch (AR3.getValue()){
            case "Not Defined (X)":
            case "Medium (M)":
                ar3 = 1;
                break;
            case "Low (L)":
                ar3 = 0.5;
                break;
            case "High (H)":
                ar3 = 1.5;
                break;
        }
        if(AV33.getValue().equals("Not Defined (X)") && AC33.getValue().equals("Not Defined (X)") && PR33.getValue().equals("Not Defined (X)") && UI33.getValue().equals("Not Defined (X)") && S33.getValue().equals("Not Defined (X)") && C33.getValue().equals("Not Defined (X)") && I33.getValue().equals("Not Defined (X)") && A33.getValue().equals("Not Defined (X)") && CR3.getValue().equals("Not Defined (X)") && IR3.getValue().equals("Not Defined (X)") && AR3.getValue().equals("Not Defined (X)")){
            environmentalScoreBool = false;
        }


        if(baseScoreBool){
            double impactBase = 1 - (1 - c3) * (1 - i3) * (1 - a3);
            System.out.println("impactBase = 1 - (1 - " + c3 + ") * (1 - " + i3 + ") * (1 - " + a3 + ") = "  + impactBase);
            double exploitability = 8.22 * av3 * ac3 * pr3 * ui3;
            System.out.println("exploitability = 8.22 * " + av3 + " * " + ac3 + " * " + pr3 + " * " + ui3 + " = " + exploitability);
            double impact = 0;
            double baseScore = 0;
            if(s3 == 0){
                impact = 6.42 * impactBase;
                baseScore = Math.ceil(Math.min(impact + exploitability, 10) * 10) / 10.0;
                System.out.println("impact = 6.42 * " + impactBase + " = " + impact);
                System.out.println("baseScore = Math.ceil(Math.min(" + impact + " + " + exploitability + ", 10) * 10) / 10.0 = " + baseScore);
            }
            if(s3 == 1){
                impact = 7.52 * (impactBase - 0.029) - 3.25 * Math.pow(impactBase - 0.02, 15);
                baseScore = Math.ceil(Math.min(1.08 * (impact + exploitability), 10) * 10) / 10.0;
                System.out.println("impact = 7.52 * (" + impactBase + " - 0.029) - 3.25 * Math.pow(" + impactBase + " - 0.02, 15) = " + impact);
                System.out.println("baseScore = Math.ceil(Math.min(1.08 * (" + impact + " + " + exploitability + "), 10) * 10) / 10.0 = " + baseScore);
            }
            if(impact <= 0){
                baseScore = 0;
            }
            basicScoreLabel.setText(String.valueOf(baseScore));
            impactSubcoreLabel.setText(String.valueOf(Math.round(impact * 10)  / 10.0));
            exploitabilitySubcoreLabel.setText(String.valueOf(Math.round(exploitability * 10)  / 10.0));
            overallScoreLabel.setText(String.valueOf(baseScore));

            if(temporalScoreBool){
                double temporalScore = Math.ceil(baseScore * e3 * rl3 * rc3 * 10) / 10.0;
                System.out.println("temporalScore = Math.ceil(" + baseScore + " * " + e3 + " * " + rl3 + " * " + rc3 + " * 10) / 10.0 = " + temporalScore);
                temporalScoreLabel.setText(String.valueOf(temporalScore));
                overallScoreLabel.setText(String.valueOf(temporalScore));
            }

            if(environmentalScoreBool){
                double mImpactBase = Math.min((1 - (1 - c33 * cr3) * (1 - i33 * ir3) * (1 - a33 * ar3)), 0.915);
                System.out.println("mImpactBase = Math.min((1 - (1 - " + c33 + " * " + cr3 + ") * (1 - " + i33 + " * " + ir3 + ") * (1 - " + a33 + " * " + ar3 + ")), 0.915) = " + mImpactBase);
                double mExploitability = 8.22 * av33 * ac33 * pr33 * ui33;
                System.out.println("mExploitability = 8.22 * " + av33 + " * " + ac33 + " * " + pr33 + " * " + ui33 + " = " + mExploitability);
                double mImpact = 0;
                double environmentalScore = 0;
                if(s33 == 0){
                    mImpact = 6.42 * mImpactBase;
                    environmentalScore = Math.ceil(Math.ceil(Math.min(mImpact + mExploitability, 10) * 10) / 10.0 * e3 * rl3 * rc3 * 10) / 10.0;
                    System.out.println("mImpact = 6.42 * " + mImpactBase + " = " + mImpact);
                    System.out.println("environmentalScore = Math.ceil(Math.ceil(Math.min(" + mImpact + " + " + mExploitability + ", 10) * 10) / 10.0 * " + e3 + " * " + rl3 + " * " + rc3 + " * 10) / 10.0 = " + environmentalScore);
                }
                if(s33 == 1){
                    mImpact = 7.52 * (mImpactBase - 0.029) - 3.25 * Math.pow(mImpactBase - 0.02, 15);
                    environmentalScore = Math.ceil(Math.ceil(Math.min(1.08 * (mImpact + mExploitability), 10) * 10) / 10.0 * e3 * rl3 * rc3 * 10) / 10.0;
                    System.out.println("mImpact = 7.52 * (" + mImpactBase + " - 0.029) - 3.25 * Math.pow(" + mImpactBase + " - 0.02, 15) = " + mImpact);
                    System.out.println("environmentalScore = Math.ceil(Math.ceil(Math.min(1.08 * (" + mImpact + " + " + mExploitability + "), 10) * 10) / 10.0 * " + e3 + " * " + rl3 + " * " + rc3 + " * 10) / 10.0 = " + environmentalScore);
                }
                if(mImpact <= 0){
                    environmentalScore = 0;
                }
                environmentalScoreLabel.setText(String.valueOf(environmentalScore));
                modifiedSubscoreLabel.setText(String.valueOf(Math.round(mImpact * 10)  / 10.0));
                overallScoreLabel.setText(String.valueOf(environmentalScore));
            }
        }
    }
}