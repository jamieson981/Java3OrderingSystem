

import Models.MenuItem;
import Services.MenuService;
import Services.OrderService;
import java.awt.Color;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.lang.Iterable;

public class WelcomeToResMenu extends javax.swing.JFrame {
    
    private Connection conn;
    DefaultListModel<MenuItem> menuListModel = new DefaultListModel<>();
    
       ImageIcon iconLogo;
       String selectName;
       BigDecimal total = BigDecimal.ZERO;
       
    public WelcomeToResMenu() {
        initComponents();
        
        menuListModel.add(0, new MenuItem()); 
        menuListModel.add(1, new MenuItem()); 
        menuListModel.add(2, new MenuItem()); 
        menuListModel.add(3, new MenuItem());
        fillMenu(dlg_cbDrink, "Drinks");
        fillMenu(dlg_cbMainCourse, "Mains");
        fillMenu(dlg_cbStarter, "Starters");
        fillMenu(dlg_cbDessert, "Desserts");
        btOrder.setBackground(Color.DARK_GRAY);
        
        
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        dlgDetails_lblDate.setText(dateFormat.format(cal.getTime()));
        
        
    }
    
    public void fillMenu(javax.swing.JComboBox<String> cBox, String category) {
        MenuService mService = new MenuService();
        List<MenuItem> items = mService.getItemsByCategory(category);
        ArrayList<String> itemNames = new ArrayList<String>();
        itemNames.add("Pick an item");
        for (MenuItem it : items) {
             itemNames.add(it.getItemName());
//           System.out.println(it.getItemName());
        }
        cBox.setModel(new DefaultComboBoxModel(itemNames.toArray()));
    }
    
    public void addToOrder(String order){
        String sql = "SELECT * FROM menu where name =?";
        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,order);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                dlg_lblFoodName.setText(set.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgMenu = new javax.swing.JDialog();
        dlg_lblStarter = new javax.swing.JLabel();
        dlg_cbStarter = new javax.swing.JComboBox<>();
        dlg_lblMainCourse = new javax.swing.JLabel();
        dlg_cbMainCourse = new javax.swing.JComboBox<>();
        dlg_lblDessert = new javax.swing.JLabel();
        dlg_cbDessert = new javax.swing.JComboBox<>();
        dlg_lblDrink = new javax.swing.JLabel();
        dlg_cbDrink = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMenu = new javax.swing.JList<>();
        dlg_lblFoodName = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        lbl_total = new javax.swing.JLabel();
        dlg_btBack = new javax.swing.JButton();
        dlg_btOrder = new javax.swing.JButton();
        dlg_btPayment = new javax.swing.JButton();
        dlg_btDelete = new javax.swing.JButton();
        dlgPayment = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dlgPayment_tfTable = new javax.swing.JTextField();
        dlgPayment_tfTotal = new javax.swing.JTextField();
        dlgPayment_cbMethod = new javax.swing.JComboBox<>();
        dlgPayment_Save = new javax.swing.JButton();
        dlgPayment_lblCalendar = new javax.swing.JLabel();
        dlgPayment_Recipt = new javax.swing.JButton();
        dlgDetails = new javax.swing.JDialog();
        dlgDetails_lblDate = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        dlgDtails_lblName = new javax.swing.JLabel();
        dlgDetails_lblPic = new javax.swing.JLabel();
        dlgDetails_lblIngredients = new javax.swing.JLabel();
        dlgDetails_Pric = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dlgDetails_btnOK = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        lblWelcome = new javax.swing.JLabel();
        btOrder = new javax.swing.JButton();

        dlgMenu.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dlgMenuWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                dlgMenuWindowOpened(evt);
            }
        });

        dlg_lblStarter.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dlg_lblStarter.setText("STARTER");

        dlg_cbStarter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlg_cbStarterActionPerformed(evt);
            }
        });

        dlg_lblMainCourse.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dlg_lblMainCourse.setText("MAIN COURSE");

        dlg_cbMainCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chicken", "Duck", "Pork", "Fish" }));
        dlg_cbMainCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlg_cbMainCourseActionPerformed(evt);
            }
        });

        dlg_lblDessert.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dlg_lblDessert.setText("DESSERT");

        dlg_cbDessert.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clafoutis", "Profiterole", "Souffle", "Mousse" }));
        dlg_cbDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlg_cbDessertActionPerformed(evt);
            }
        });

        dlg_lblDrink.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        dlg_lblDrink.setText("DRINK");

        dlg_cbDrink.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Martini", "Lagoon", "Serena", "SeaBreeze" }));
        dlg_cbDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlg_cbDrinkActionPerformed(evt);
            }
        });

        lstMenu.setModel(menuListModel);
        lstMenu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstMenuMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lstMenu);

        dlg_lblFoodName.setText(".");

        txt_total.setEditable(false);
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        lbl_total.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        lbl_total.setText("total");

        dlg_btBack.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dlg_btBack.setText("Back");

        dlg_btOrder.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dlg_btOrder.setText("Detail");
        dlg_btOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlg_btOrderActionPerformed(evt);
            }
        });

        dlg_btPayment.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dlg_btPayment.setText("Payment");
        dlg_btPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlg_btPaymentActionPerformed(evt);
            }
        });

        dlg_btDelete.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dlg_btDelete.setText("Delete");
        dlg_btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlg_btDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgMenuLayout = new javax.swing.GroupLayout(dlgMenu.getContentPane());
        dlgMenu.getContentPane().setLayout(dlgMenuLayout);
        dlgMenuLayout.setHorizontalGroup(
            dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgMenuLayout.createSequentialGroup()
                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dlgMenuLayout.createSequentialGroup()
                        .addGap(0, 100, Short.MAX_VALUE)
                        .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(dlgMenuLayout.createSequentialGroup()
                                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dlg_lblStarter)
                                    .addComponent(dlg_cbStarter, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(dlgMenuLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(dlg_cbMainCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgMenuLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(dlg_lblMainCourse)))
                                .addGap(41, 41, 41)
                                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dlg_lblDessert)
                                    .addComponent(dlg_cbDessert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(dlg_lblFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dlg_cbDrink, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dlg_lblDrink, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(dlgMenuLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dlg_btDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dlg_btOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dlg_btPayment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                            .addComponent(dlg_btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(dlgMenuLayout.createSequentialGroup()
                                .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_total))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        dlgMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dlg_cbDessert, dlg_cbDrink, dlg_cbMainCourse, dlg_cbStarter});

        dlgMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dlg_lblDessert, dlg_lblDrink, dlg_lblMainCourse, dlg_lblStarter});

        dlgMenuLayout.setVerticalGroup(
            dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dlg_lblFoodName)
                .addGap(21, 21, 21)
                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlg_lblDrink)
                    .addComponent(dlg_lblDessert)
                    .addComponent(dlg_lblMainCourse)
                    .addComponent(dlg_lblStarter))
                .addGap(15, 15, 15)
                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlg_cbStarter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlg_cbMainCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlg_cbDessert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlg_cbDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgMenuLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(dlg_btBack)
                        .addGap(36, 36, 36)
                        .addComponent(dlg_btOrder)
                        .addGap(41, 41, 41)
                        .addComponent(dlg_btDelete)
                        .addGap(33, 33, 33)
                        .addComponent(dlg_btPayment)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_total)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(253, Short.MAX_VALUE))
        );

        jLabel1.setText("Table NO:");

        jLabel2.setText("Pament Method");

        jLabel3.setText("Total");

        dlgPayment_tfTotal.setEditable(false);

        dlgPayment_cbMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Credit", "Debit", "Cash", "Cheque" }));
        dlgPayment_cbMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgPayment_cbMethodActionPerformed(evt);
            }
        });

        dlgPayment_Save.setText("Save Transaction");
        dlgPayment_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgPayment_SaveActionPerformed(evt);
            }
        });

        dlgPayment_Recipt.setText("Save & print");
        dlgPayment_Recipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgPayment_ReciptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgPaymentLayout = new javax.swing.GroupLayout(dlgPayment.getContentPane());
        dlgPayment.getContentPane().setLayout(dlgPaymentLayout);
        dlgPaymentLayout.setHorizontalGroup(
            dlgPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgPaymentLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(dlgPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dlgPaymentLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dlgPayment_cbMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dlgPaymentLayout.createSequentialGroup()
                        .addGroup(dlgPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(dlgPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dlgPayment_tfTotal)
                            .addComponent(dlgPayment_tfTable))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgPaymentLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(dlgPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgPaymentLayout.createSequentialGroup()
                        .addComponent(dlgPayment_lblCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgPaymentLayout.createSequentialGroup()
                        .addComponent(dlgPayment_Recipt, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dlgPayment_Save)
                        .addGap(83, 83, 83))))
        );
        dlgPaymentLayout.setVerticalGroup(
            dlgPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgPaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dlgPayment_lblCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dlgPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlgPayment_tfTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dlgPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlgPayment_tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dlgPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlgPayment_cbMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(dlgPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgPayment_Save)
                    .addComponent(dlgPayment_Recipt))
                .addGap(36, 36, 36))
        );

        dlgDetails.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                dlgDetailsWindowOpened(evt);
            }
        });

        dlgDetails_lblDate.setText("jLabel4");
        dlgDetails.getContentPane().add(dlgDetails_lblDate, java.awt.BorderLayout.PAGE_END);

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 500));
        jPanel1.setLayout(null);

        dlgDtails_lblName.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        dlgDtails_lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dlgDtails_lblName.setText("jLabel11");
        jPanel1.add(dlgDtails_lblName);
        dlgDtails_lblName.setBounds(150, 20, 300, 40);
        jPanel1.add(dlgDetails_lblPic);
        dlgDetails_lblPic.setBounds(130, 70, 330, 150);

        dlgDetails_lblIngredients.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        dlgDetails_lblIngredients.setText("jLabel9");
        jPanel1.add(dlgDetails_lblIngredients);
        dlgDetails_lblIngredients.setBounds(230, 230, 330, 19);

        dlgDetails_Pric.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        dlgDetails_Pric.setText("jLabel8");
        jPanel1.add(dlgDetails_Pric);
        dlgDetails_Pric.setBounds(230, 280, 200, 19);

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel7.setText("Price:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(120, 280, 50, 20);

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel8.setText("Ingredients: ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(110, 230, 90, 19);

        dlgDetails_btnOK.setText("OK");
        dlgDetails_btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgDetails_btnOKActionPerformed(evt);
            }
        });
        jPanel1.add(dlgDetails_btnOK);
        dlgDetails_btnOK.setBounds(260, 320, 100, 30);

        jLabel5.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 590, 410);

        dlgDetails.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        dlgDetails.setJMenuBar(jMenuBar1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 51));

        lblWelcome.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome to swing Ordering System");

        btOrder.setBackground(new java.awt.Color(255, 255, 255));
        btOrder.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        btOrder.setForeground(new java.awt.Color(255, 255, 255));
        btOrder.setText("Order");
        btOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(btOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btOrder)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dlg_btOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlg_btOrderActionPerformed
       int currIndex = -1;
        try {
            MenuItem selectItem = new MenuItem();
            currIndex = lstMenu.getSelectedIndex();
            if (currIndex == -1) {
                JOptionPane.showMessageDialog(null,
                    "Select One Item...",
                    "Select One Item",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            selectItem = lstMenu.getSelectedValue();
            selectName = selectItem.getItemName();
            System.out.println(selectName);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Order your Dish order...",
                    "Select OneItem",
                    JOptionPane.ERROR_MESSAGE);
        } 
        
        if (!(selectName == null)) {
            dlgDtails_lblName.setText(selectName);
            MenuService myService = new MenuService();
            MenuItem item = myService.getItemByName(selectName);
            dlgDetails_lblIngredients.setText(item.getIngredients());
            dlgDetails_Pric.setText(String.valueOf(item.getPrice()));
            iconLogo = new ImageIcon("image\\"+selectName+".jpg");
            // In init() method write this code
            dlgDetails_lblPic.setIcon(iconLogo);
        }                 
        
        dlgDetails.pack();
        
        dlgDetails.setVisible(true);
        currIndex = lstMenu.getSelectedIndex();
        dlgMenu.setVisible(false);
        dlg_lblFoodName.setText("");
    
    }//GEN-LAST:event_dlg_btOrderActionPerformed

    private void btOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOrderActionPerformed
        dlgMenu.pack();
        dlgMenu.setVisible(true);
        
    }//GEN-LAST:event_btOrderActionPerformed

    private void dlg_cbStarterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlg_cbStarterActionPerformed
        addRemoveMenuList(0, dlg_cbStarter);
    }//GEN-LAST:event_dlg_cbStarterActionPerformed

    private void dlg_cbMainCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlg_cbMainCourseActionPerformed
        addRemoveMenuList(1, dlg_cbMainCourse);
    }//GEN-LAST:event_dlg_cbMainCourseActionPerformed

    private void dlg_cbDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlg_cbDessertActionPerformed
        addRemoveMenuList(2, dlg_cbDessert);
    }//GEN-LAST:event_dlg_cbDessertActionPerformed

    private void dlg_cbDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlg_cbDrinkActionPerformed
        addRemoveMenuList(3, dlg_cbDrink);
    }//GEN-LAST:event_dlg_cbDrinkActionPerformed

    private void addRemoveMenuList(int index, javax.swing.JComboBox<String> box) {
        try {
            if (menuListModel.get(index).getPrice() != null){
                total = total.subtract(menuListModel.get(index).getPrice());
            }
            menuListModel.remove(index);
        } catch(IndexOutOfBoundsException e){
        // do nothing
        }
        if (!((String)box.getSelectedItem()).equals("Pick an item")) {            
            
            MenuService mService = new MenuService();
            MenuItem item = mService.getItemByName((String)box.getSelectedItem());        
            menuListModel.add(index, item);
            
            total = total.add(item.getPrice());
            
        } else {
            menuListModel.add(index, new MenuItem());
        }
        txt_total.setText((String.valueOf(total)));
    }
    
    private void lstMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstMenuMouseReleased
        // TODO add your handling code here:
        int currIndex = -1;
        if (evt.getButton() == 2) { // right button
            currIndex = lstMenu.locationToIndex(evt.getPoint());
            //System.out.println("Index: " + index);
            if (currIndex != -1) {
                lstMenu.setSelectedIndex(currIndex); //select the item
//                popupMenu.show(lstMenu, evt.getX(), evt.getY()); //and show the menu
            }
        }
    }//GEN-LAST:event_lstMenuMouseReleased

    private void dlg_btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlg_btDeleteActionPerformed
        // TODO add your handling code here:
        int currIndex = -1;
        currIndex = lstMenu.getSelectedIndex();
        if (currIndex == -1) {
            JOptionPane.showMessageDialog(null,
                "Select One Item...",
                "Select OneI tem",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        total=total.subtract(menuListModel.getElementAt(currIndex).getPrice());
        txt_total.setText((String.valueOf(total)));
        menuListModel.get(currIndex).getPrice();
        menuListModel.remove(currIndex);
        menuListModel.add(currIndex, new MenuItem());
        switch (currIndex) {
            case 0:  dlg_cbStarter.setSelectedIndex(0);
                     break;
            case 1:  dlg_cbMainCourse.setSelectedIndex(0);
                     break;
            case 2:  dlg_cbDessert.setSelectedIndex(0);
                     break;
            case 3:  dlg_cbDrink.setSelectedIndex(0);
        }

    }//GEN-LAST:event_dlg_btDeleteActionPerformed

    private void dlg_btPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlg_btPaymentActionPerformed
        // TODO add your handling code here:
        
        if (total.doubleValue() > 0.00) {
        dlgPayment.pack();
        dlgPayment.setVisible(true);
        dlgPayment_tfTotal.setText((String.valueOf(total)));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        dlgPayment_lblCalendar.setText(dateFormat.format(cal.getTime()));
        } else {
            JOptionPane.showMessageDialog(null,
                "Please select items to purchase",
                "No items on order",
                JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_dlg_btPaymentActionPerformed

    private void dlgPayment_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgPayment_SaveActionPerformed
        // TODO add your handling code here:
        
        
        String errors = "";
        if (!dlgPayment_tfTable.getText().matches("^[0-9]{1,2}$")||(Integer.parseInt(dlgPayment_tfTable.getText())>30)) {
            errors += "* Enter Table Number between 1 and 30.\n";
        }
        if (dlgPayment_cbMethod.getSelectedItem()=="None") {
            errors += "* Select Payment Method\n";
        }
        //send
        if (errors.isEmpty()) {
            OrderService oService = new OrderService();
            String paymentType = dlgPayment_cbMethod.getModel().getSelectedItem().toString();
            int orderId = oService.save(Integer.parseInt(dlgPayment_tfTable.getText()), total, paymentType);
            
            for (int i = 0; i < menuListModel.getSize(); i++) {
                MenuItem item = menuListModel.getElementAt(i);
                if (item.getId() != 0) {
                    oService.saveItem(orderId, item.getId());
                }
            }
            try {
                dlgMenu.setVisible(false);
                dlgPayment.setVisible(false);
                menuListModel.removeAllElements();
                total=new BigDecimal(0);
                txt_total.setText(" ");
                
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "File writing error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                        errors,
                        "Input data error",
                        JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_dlgPayment_SaveActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        
        
    }//GEN-LAST:event_txt_totalActionPerformed

    private void dlgPayment_ReciptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgPayment_ReciptActionPerformed
     
    }//GEN-LAST:event_dlgPayment_ReciptActionPerformed

   
    private void dlgDetails_btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgDetails_btnOKActionPerformed
        
        dlgMenu.pack();
        dlgMenu.setVisible(true);
        dlgDetails.setVisible(false);
        selectName = null;
        
    }//GEN-LAST:event_dlgDetails_btnOKActionPerformed

    private void dlgMenuWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgMenuWindowOpened
      
    }//GEN-LAST:event_dlgMenuWindowOpened

 
    private void dlgDetailsWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgDetailsWindowOpened
        
    }//GEN-LAST:event_dlgDetailsWindowOpened


    private void dlgPayment_cbMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgPayment_cbMethodActionPerformed

    }//GEN-LAST:event_dlgPayment_cbMethodActionPerformed

    private void dlgMenuWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgMenuWindowClosing
        // TODO add your handling code here:
        menuListModel.removeAllElements();
        txt_total.setText("");
        total=new BigDecimal(0);
    }//GEN-LAST:event_dlgMenuWindowClosing

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WelcomeToResMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeToResMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeToResMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeToResMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeToResMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOrder;
    private javax.swing.JDialog dlgDetails;
    private javax.swing.JLabel dlgDetails_Pric;
    private javax.swing.JButton dlgDetails_btnOK;
    private javax.swing.JLabel dlgDetails_lblDate;
    private javax.swing.JLabel dlgDetails_lblIngredients;
    private javax.swing.JLabel dlgDetails_lblPic;
    private javax.swing.JLabel dlgDtails_lblName;
    private javax.swing.JDialog dlgMenu;
    private javax.swing.JDialog dlgPayment;
    private javax.swing.JButton dlgPayment_Recipt;
    private javax.swing.JButton dlgPayment_Save;
    private javax.swing.JComboBox<String> dlgPayment_cbMethod;
    private javax.swing.JLabel dlgPayment_lblCalendar;
    private javax.swing.JTextField dlgPayment_tfTable;
    private javax.swing.JTextField dlgPayment_tfTotal;
    private javax.swing.JButton dlg_btBack;
    private javax.swing.JButton dlg_btDelete;
    private javax.swing.JButton dlg_btOrder;
    private javax.swing.JButton dlg_btPayment;
    private javax.swing.JComboBox<String> dlg_cbDessert;
    private javax.swing.JComboBox<String> dlg_cbDrink;
    private javax.swing.JComboBox<String> dlg_cbMainCourse;
    private javax.swing.JComboBox<String> dlg_cbStarter;
    private javax.swing.JLabel dlg_lblDessert;
    private javax.swing.JLabel dlg_lblDrink;
    private javax.swing.JLabel dlg_lblFoodName;
    private javax.swing.JLabel dlg_lblMainCourse;
    private javax.swing.JLabel dlg_lblStarter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JList<MenuItem> lstMenu;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
