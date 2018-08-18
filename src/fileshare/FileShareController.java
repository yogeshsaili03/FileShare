package fileshare;

import Mail.SendSMTP;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Yogesh
 */
public class FileShareController implements Initializable {
    
    @FXML
    private Label FIle_Share;
    
    @FXML
    private JFXRadioButton Text;
    
    @FXML
    private MaterialDesignIconView Refresh;
    
    @FXML
    private ToggleGroup Select_Type;
    
    @FXML
    private JFXRadioButton Image;
    
    @FXML
    private JFXRadioButton Video;
    
    @FXML
    private JFXRadioButton Document;
    
    @FXML
    private JFXRadioButton Music;
    
    @FXML
    private AnchorPane AP_Select;
    
    @FXML
    private JFXButton Send_Raised;
    
    @FXML
    private JFXButton Receive_Raised;
    
    @FXML
    private JFXButton Receive_Flat;
    
    @FXML
    private JFXButton Send_Flat;
    
    @FXML
    private JFXButton Proceed_Raised;
    
    @FXML
    private JFXButton Proceed_Flat;
    
    @FXML
    private AnchorPane Anc_Receiver_ip;
    
    @FXML
    private Label Ip_Label;
    
    @FXML
    private AnchorPane Anch_Setting;
    
    @FXML
    private MaterialDesignIconView Setting_Dis;
    
    @FXML
    private MaterialDesignIconView Setting_Hi;
    
    @FXML
    private MaterialIconView feedback_White;
    
    @FXML
    private MaterialIconView feedback_Black;
    
    @FXML
    private MaterialIconView US_Grey;
    
    @FXML
    private MaterialIconView US_White;
    
    @FXML
    private AnchorPane Anch_feed;
    
    @FXML
    private JFXTextField Email;
    
    @FXML
    private MaterialDesignIconView Star_Half_1;
    
    @FXML
    private MaterialDesignIconView Star_Half_2;
    
    @FXML
    private MaterialDesignIconView Star_Half_5;
    
    @FXML
    private MaterialDesignIconView Star_Half_3;
    
    @FXML
    private MaterialDesignIconView Star_Half_4;
    
    @FXML
    private MaterialDesignIconView Star_Full_5;
    
    @FXML
    private MaterialDesignIconView Star_Full_4;
    
    @FXML
    private MaterialDesignIconView Star_Full_3;
    
    @FXML
    private MaterialDesignIconView Star_Full_2;
    
    @FXML
    private MaterialDesignIconView Star_Full_1;
    
    @FXML
    private JFXButton Submit;
    
    @FXML
    private AnchorPane Anch_main;
    
    @FXML
    private Label Rate;
    
    @FXML
    private AnchorPane ANCH_SUBmit;
    
    int rate;
    
    @FXML
    private JFXTextField Text_Feedback;
    
    @FXML
    private Label SucFail;
    
    @FXML
    private FontAwesomeIconView Close;
    
    @FXML
    void Exit(MouseEvent event) {
        System.exit(0);
    }
    
    @FXML
    void Star_1(MouseEvent event) {
        Star_Full_1.setVisible(true);
        Rate.setText("  Hated it");
        Refresh.setVisible(true);
        ANCH_SUBmit.setVisible(true);
        rate = 1;
    }
    
    @FXML
    void Star_2(MouseEvent event) {
        Star_Full_1.setVisible(true);
        Star_Full_2.setVisible(true);
        Rate.setText("Disliked it");
        Refresh.setVisible(true);
        ANCH_SUBmit.setVisible(true);
        rate = 2;
    }
    
    @FXML
    void Star_3(MouseEvent event) {
        Star_Full_1.setVisible(true);
        Star_Full_2.setVisible(true);
        Star_Full_3.setVisible(true);
        Rate.setText("   It's OK");
        Refresh.setVisible(true);
        ANCH_SUBmit.setVisible(true);
        rate = 3;
    }
    
    @FXML
    void Star_4(MouseEvent event) {
        Star_Full_1.setVisible(true);
        Star_Full_2.setVisible(true);
        Star_Full_3.setVisible(true);
        Star_Full_4.setVisible(true);
        Rate.setText("  Liked it");
        Refresh.setVisible(true);
        ANCH_SUBmit.setVisible(true);
        rate = 4;
    }
    
    @FXML
    void Star_5(MouseEvent event) {
        Star_Full_1.setVisible(true);
        Star_Full_2.setVisible(true);
        Star_Full_3.setVisible(true);
        Star_Full_4.setVisible(true);
        Star_Full_5.setVisible(true);
        Rate.setText("  Loved it");
        Refresh.setVisible(true);
        ANCH_SUBmit.setVisible(true);
        rate = 5;
    }
    
    @FXML
    void Star_6(MouseEvent event) {
        Star_Full_1.setVisible(true);
        Star_Full_2.setVisible(false);
        Star_Full_3.setVisible(false);
        Star_Full_4.setVisible(false);
        Star_Full_5.setVisible(false);
        Rate.setText("  Hated it");
        Refresh.setVisible(true);
        ANCH_SUBmit.setVisible(true);
        rate = 1;
    }
    
    @FXML
    void Star_7(MouseEvent event) {
        Star_Full_1.setVisible(true);
        Star_Full_2.setVisible(true);
        Star_Full_3.setVisible(false);
        Star_Full_4.setVisible(false);
        Star_Full_5.setVisible(false);
        Rate.setText("Disliked it");
        Refresh.setVisible(true);
        ANCH_SUBmit.setVisible(true);
        rate = 2;
    }
    
    @FXML
    void Star_8(MouseEvent event) {
        Star_Full_1.setVisible(true);
        Star_Full_2.setVisible(true);
        Star_Full_3.setVisible(true);
        Star_Full_4.setVisible(false);
        Star_Full_5.setVisible(false);
        Rate.setText("   It's OK");
        Refresh.setVisible(true);
        ANCH_SUBmit.setVisible(true);
        rate = 3;
    }
    
    @FXML
    void Star_9(MouseEvent event) {
        Star_Full_1.setVisible(true);
        Star_Full_2.setVisible(true);
        Star_Full_3.setVisible(true);
        Star_Full_4.setVisible(true);
        Star_Full_5.setVisible(false);
        Rate.setText("  Liked it");
        Refresh.setVisible(true);
        ANCH_SUBmit.setVisible(true);
        rate = 4;
    }
    
    @FXML
    void Star_10(MouseEvent event) {
        Star_Full_1.setVisible(true);
        Star_Full_2.setVisible(true);
        Star_Full_3.setVisible(true);
        Star_Full_4.setVisible(true);
        Star_Full_5.setVisible(true);
        Rate.setText("  Loved it");
        Refresh.setVisible(true);
        ANCH_SUBmit.setVisible(true);
        rate = 5;
    }
    
    @FXML
    void refresh(MouseEvent event) {
        Star_Full_1.setVisible(false);
        Star_Full_2.setVisible(false);
        Star_Full_3.setVisible(false);
        Star_Full_4.setVisible(false);
        Star_Full_5.setVisible(false);
        Rate.setText("");
        Refresh.setVisible(false);
        ANCH_SUBmit.setVisible(false);
        rate = 0;
        Email.setText("");
        Text_Feedback.setText("");
        
    }
    
    @FXML
    void Submit(ActionEvent event) {
        System.out.println(Email.getText());
        System.out.println(rate);
        System.out.println(Text_Feedback.getText());
        String Usermail = "Thank you for trusting us! Together with our team, we promise to do our very best just to cater every little thing you need. \n\n Regards \n Team Fileshare ";
        String result = SendSMTP.sendMail(Email.getText(), Usermail, "Thank you");
        if (result.equalsIgnoreCase("sent")) {
            SucFail.setText("   Feedback Recorded.");
            
        }
        if (result.equalsIgnoreCase("failed")) {
            SucFail.setText("Feedback not Recorded.");
        }
    }
    
    @FXML
    void Feed_Black(MouseEvent event) {
        feedback_Black.setVisible(false);
        feedback_White.setVisible(true);
        Anch_feed.setVisible(false);
        Anch_main.setVisible(true);
        ANCH_SUBmit.setVisible(false);
        
    }
    
    @FXML
    void Feed_White(MouseEvent event) {
        feedback_Black.setVisible(true);
        feedback_White.setVisible(false);
        US_White.setVisible(true);
        Anch_feed.setVisible(true);
        Anch_main.setVisible(false);
        refresh(event);
    }
    
    DataOutputStream dos = null;
    DataInputStream dis = null;
    FileOutputStream fos = null;
    FileInputStream fis = null;
    Socket cs = null;
    int i = 0, sendthread = 0;
    ServerSocket ss = null;
    File file;
    Optional<String> result;
    
    @FXML
    void Proceed_Raised_Click(ActionEvent event) {
        if (!(Text.isSelected()) && !(Image.isSelected()) && !(Video.isSelected()) && !(Document.isSelected()) && !(Music.isSelected())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Select One Type to Proceed Further.");
            alert.setContentText("No Option Selected.");
            
            alert.showAndWait();
        } else if (Text.isSelected()) {
            
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            //fileChooser.setTitle("Open Resource File");
            file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                if (sendthread == 0) {
                    sendthread++;
                    System.out.println(file + " " + file.getName());
                    
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Ip Address Dialog");
                    dialog.setHeaderText("Selected File : " + file.getName());
                    
                    dialog.setContentText("Enter IP Address of Receiver:");
                    result = dialog.showAndWait();
                    
                    if (result.isPresent()) {
                        SendT st = new SendT();
                        st.start();
                    }
                } else if (sendthread > 0) {
                    SendT st = new SendT();
                    st.stop();
                    SendT stZERO = new SendT();
                    stZERO.start();
                    
                }
            }
            
        } else if (Image.isSelected()) {
            
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
            fileChooser.getExtensionFilters().add(imageFilter);
            file = fileChooser.showOpenDialog(new Stage());
            System.out.println(file);
            
            if (file != null) {
                if (sendthread == 0) {
                    sendthread++;
                    System.out.println(file + " " + file.getName());
                    
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Ip Address Dialog");
                    dialog.setHeaderText("Selected File : " + file.getName());
                    
                    dialog.setContentText("Enter IP Address of Receiver:");
                    result = dialog.showAndWait();
                    
                    if (result.isPresent()) {
                        SendT st = new SendT();
                        st.start();
                    }
                } else if (sendthread > 0) {
                    SendT st = new SendT();
                    st.stop();
                    SendT stZERO = new SendT();
                    stZERO.start();
                    
                }
            }
            
        } else if (Video.isSelected()) {
            
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Video files(*.mp4,*.flv,*.avi)", "*.mp4", "*.flv", "*.avi");
            fileChooser.getExtensionFilters().add(extFilter);
            file = fileChooser.showOpenDialog(new Stage());
            System.out.println(file);
            if (file != null) {
                if (sendthread == 0) {
                    sendthread++;
                    System.out.println(file + " " + file.getName());
                    
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Ip Address Dialog");
                    dialog.setHeaderText("Selected File : " + file.getName());
                    
                    dialog.setContentText("Enter IP Address of Receiver:");
                    result = dialog.showAndWait();
                    
                    if (result.isPresent()) {
                        SendT st = new SendT();
                        st.start();
                    }
                } else if (sendthread > 0) {
                    SendT st = new SendT();
                    st.stop();
                    SendT stZERO = new SendT();
                    stZERO.start();
                    
                }
            }
            
        } else if (Document.isSelected()) {
            
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF file(*.pdf)", "*.pdf");
            fileChooser.getExtensionFilters().add(extFilter);
            file = fileChooser.showOpenDialog(new Stage());
            System.out.println(file);
            if (file != null) {
                if (sendthread == 0) {
                    sendthread++;
                    System.out.println(file + " " + file.getName());
                    
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Ip Address Dialog");
                    dialog.setHeaderText("Selected File : " + file.getName());
                    
                    dialog.setContentText("Enter IP Address of Receiver:");
                    result = dialog.showAndWait();
                    
                    if (result.isPresent()) {
                        SendT st = new SendT();
                        st.start();
                    }
                } else if (sendthread > 0) {
                    SendT st = new SendT();
                    st.stop();
                    SendT stZERO = new SendT();
                    stZERO.start();
                    
                }
            }
            
        } else if (Music.isSelected()) {
            
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Mp3 file(*.mp3)", "*.mp3");
            fileChooser.getExtensionFilters().add(extFilter);
            file = fileChooser.showOpenDialog(new Stage());
            System.out.println(file);
            if (file != null) {
                if (sendthread == 0) {
                    sendthread++;
                    System.out.println(file + " " + file.getName());
                    
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Ip Address Dialog");
                    dialog.setHeaderText("Selected File : " + file.getName());
                    
                    dialog.setContentText("Enter IP Address of Receiver:");
                    result = dialog.showAndWait();
                    
                    if (result.isPresent()) {
                        SendT st = new SendT();
                        st.start();
                    }
                } else if (sendthread > 0) {
                    SendT st = new SendT();
                    st.stop();
                    SendT stZERO = new SendT();
                    stZERO.start();
                    
                }
            }
            
        }
    }
    
    @FXML
    void Proceed_Flat_Enter(MouseEvent event) {
        Proceed_Raised.setVisible(true);
        Proceed_Flat.setVisible(false);
    }
    
    @FXML
    void Proceed_Raised_Exit(MouseEvent event) {
        Proceed_Raised.setVisible(false);
        Proceed_Flat.setVisible(true);
    }
    
    @FXML
    void Received_Flat_Enter(MouseEvent event) {
        Receive_Raised.setVisible(true);
        Receive_Flat.setVisible(false);
    }
    
    @FXML
    void Received_Raised_Exit(MouseEvent event) {
        Receive_Raised.setVisible(false);
        Receive_Flat.setVisible(true);
    }
    
    @FXML
    void Send_Flat_Enter(MouseEvent event) {
        Send_Raised.setVisible(true);
        Send_Flat.setVisible(false);
    }
    
    @FXML
    void Send_Raised_Exit(MouseEvent event) {
        Send_Raised.setVisible(false);
        Send_Flat.setVisible(true);
    }
    
    @FXML
    void Send_Raised_Click(ActionEvent event) throws IOException {
        AP_Select.setVisible(true);
        Send_Flat.setDisable(true);
        Receive_Flat.setDisable(false);
        Anc_Receiver_ip.setVisible(false);
        Anch_Setting.setVisible(false);
        Setting_Dis.setVisible(true);
        Setting_Hi.setVisible(false);
        if (i > 0) {
            ReceiveT rt = new ReceiveT();
            rt.stop();
            i = 0;
            ss.close();
        }
        
    }
    
    @FXML
    void Received_Raised_Click(ActionEvent event) throws UnknownHostException {
        AP_Select.setVisible(false);
        Send_Flat.setDisable(false);
        Receive_Flat.setDisable(true);
        ReceiveT rt = new ReceiveT();
        rt.start();
        i++;
        Anc_Receiver_ip.setVisible(true);
        Anch_Setting.setVisible(false);
        Setting_Dis.setVisible(true);
        Setting_Hi.setVisible(false);
        
        InetAddress iAddress = InetAddress.getLocalHost();
        String Ip = iAddress.getHostAddress();
        Ip_Label.setText("Your Ip : " + Ip);
        
    }
    
    @FXML
    void Setting_Display(MouseEvent event) throws IOException {
        Anch_Setting.setVisible(true);
        Setting_Hi.setVisible(true);
        Setting_Dis.setVisible(false);
        AP_Select.setVisible(false);
        Send_Flat.setDisable(false);
        Receive_Flat.setDisable(false);
        Anc_Receiver_ip.setVisible(false);
        if (i > 0) {
            ReceiveT rt = new ReceiveT();
            rt.stop();
            i = 0;
            ss.close();
            System.err.println("stop");
            
        }
    }
    
    @FXML
    void Setting_Hide(MouseEvent event) {
        Anch_Setting.setVisible(false);
        Setting_Hi.setVisible(false);
        Setting_Dis.setVisible(true);
        feedback_White.setVisible(true);
        US_White.setVisible(true);
        ANCH_SUBmit.setVisible(false);
    }
    
    @FXML
    void US_Grey_Hi(MouseEvent event) {
        US_White.setVisible(true);
        US_Grey.setVisible(false);
    }
    
    @FXML
    void US_White_Dis(MouseEvent event) {
        US_White.setVisible(false);
        US_Grey.setVisible(true);
        feedback_White.setVisible(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Send_Raised.setVisible(false);
        Receive_Raised.setVisible(false);
        Proceed_Raised.setVisible(false);
        AP_Select.setVisible(false);
        Anc_Receiver_ip.setVisible(false);
        Anch_Setting.setVisible(false);
        Setting_Hi.setVisible(false);
        feedback_Black.setVisible(false);
        Anch_feed.setVisible(false);
        
        Star_Full_1.setVisible(false);
        Star_Full_2.setVisible(false);
        Star_Full_3.setVisible(false);
        Star_Full_4.setVisible(false);
        Star_Full_5.setVisible(false);
        
        Refresh.setVisible(false);
        ANCH_SUBmit.setVisible(false);
        
    }
    
    class ReceiveT extends Thread {
        
        @Override
        public void run() {
            
            try {
                ss = new ServerSocket(6969);
                System.err.println("Waiting...");
                InetAddress iAddress = InetAddress.getLocalHost();
                String Ip = iAddress.getHostAddress();
                System.out.println("Server Ip " + Ip);
                cs = ss.accept();
                System.err.println("Connected.");
                
                dis = new DataInputStream(cs.getInputStream());
                String File_name = dis.readUTF();
                Send_Flat.setDisable(true);
                System.out.println(File_name);
                FileOutputStream fos = new FileOutputStream(File_name);
                byte b[] = new byte[4096];
                int c;
                long file_size = dis.readLong();
                System.out.println(file_size);
                long i = 0;
                //     Total_SIZE.setText(String.valueOf(file_size));
                while (i < file_size || i == file_size) {
                    if (i == file_size) {
                        String done = dis.readUTF();
                        System.out.println(done);
                        Send_Flat.setDisable(false);
                        break;
                    } else if (i < file_size) {
                        c = dis.read(b);
                        fos.write(b, 0, c);
                        i = i + c;
                        //    send_SIZE.setText(String.valueOf(i));
                        System.err.println("Size received : " + i);
                    }
                }
                
            } catch (IOException e) {
                System.out.println("Exception in Thread: " + e);
            }
        }
    }
    
    class SendT extends Thread {
        
        @Override
        public void run() {
            
            try {
                System.out.print(result.get());
                Socket Client = new Socket(result.get(), 6969);
                System.out.print("Connected");
                dos = new DataOutputStream(Client.getOutputStream());
                dos.writeUTF(file.getName());
                Receive_Flat.setDisable(true);
                fis = new FileInputStream(file);
                byte b[] = new byte[4096];
                int c;
                dos.writeLong(file.length());
                System.out.println(file.length());
                long initial = 0;
                while (initial < file.length()) {
                    c = fis.read(b);
                    dos.write(b, 0, c);
                    initial = initial + c;
                }
                dos.writeUTF("DONE");
                Receive_Flat.setDisable(false);
            } catch (IOException ex) {
                
                System.out.println("sfdhmj,ksdfghj,k");
                
            }
        }
    }
    
}
