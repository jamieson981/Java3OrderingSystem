
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Arad
 */
public class WelcomeToResMenu extends javax.swing.JFrame {

  
    public static final String DBUSER = "restaurant";
    public static final String DBPASS = "as5SRxjW5Roq3kbx";
    private Connection conn;
    DefaultListModel<MenuDishOrder> menuListModel = new DefaultListModel<>();
//    BigDecimal total =BigDecimal.ZERO;
    
     
       ImageIcon iconLogo;

    public WelcomeToResMenu() {
   
           
            initComponents();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/restaurant", DBUSER, DBPASS);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "Database access error",
                        JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(WelcomeToResMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

        
    }
    
    public void addToOrder(String order){
        String sql = "SELECT * FROM menu where name =?";
        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,order);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                dlg_tfIngredience.setText(set.getString("ingredience"));
                dlg_tfCalorie.setText(set.getInt("calories") + "");
                dlg_tfPrice.setText(set.getString(String.valueOf("price")));
                dlg_lblFoodName.setText(set.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @SuppressWarnings("unchecked")
     BigDecimal total =BigDecimal.ZERO;
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
        dlg_lblImage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMenu = new javax.swing.JList<>();
        dlg_lblFoodName = new javax.swing.JLabel();
        dlg_tfPayment = new javax.swing.JTextField();
        dlg_tfIngredience = new javax.swing.JTextField();
        dlg_lblIngredience = new javax.swing.JLabel();
        dlg_lblPrice = new javax.swing.JLabel();
        dlg_lblCalorie = new javax.swing.JLabel();
        dlg_tfPrice = new javax.swing.JTextField();
        dlg_tfCalorie = new javax.swing.JTextField();
        dlg_btBack = new javax.swing.JButton();
        dlg_btOrder = new javax.swing.JButton();
        dlg_btPayment = new javax.swing.JButton();
        dlg_btDelete = new javax.swing.JButton();
        dlg_lblIngredience1 = new javax.swing.JLabel();
        dlgPayment = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dlgPayment_tfTable = new javax.swing.JTextField();
        dlgPayment_tfTotal = new javax.swing.JTextField();
        dlgPayment_cbMethod = new javax.swing.JComboBox<>();
        dlgPayment_Save = new javax.swing.JButton();
        dlgPayment_lblCalendar = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        btOrder = new javax.swing.JButton();

        dlg_lblStarter.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dlg_lblStarter.setText("STARTER");

        dlg_cbStarter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ceps", "Truffle", "FoieGras", "Pudding" }));
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

        dlg_tfIngredience.setEditable(false);

        dlg_lblIngredience.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dlg_lblIngredience.setText("total");

        dlg_lblPrice.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dlg_lblPrice.setText("Price");

        dlg_lblCalorie.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dlg_lblCalorie.setText("Calorie");

        dlg_tfPrice.setEditable(false);

        dlg_tfCalorie.setEditable(false);

        dlg_btBack.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dlg_btBack.setText("Back");

        dlg_btOrder.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dlg_btOrder.setText("Order");
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

        dlg_lblIngredience1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dlg_lblIngredience1.setText("Ingredience");

        javax.swing.GroupLayout dlgMenuLayout = new javax.swing.GroupLayout(dlgMenu.getContentPane());
        dlgMenu.getContentPane().setLayout(dlgMenuLayout);
        dlgMenuLayout.setHorizontalGroup(
            dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(dlg_lblDrink, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(dlgMenuLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(dlg_lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(dlgMenuLayout.createSequentialGroup()
                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dlgMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dlg_lblCalorie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dlg_lblIngredience1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dlg_lblPrice, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dlg_tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dlg_tfCalorie, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dlgMenuLayout.createSequentialGroup()
                                .addComponent(dlg_tfIngredience, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(dlg_lblIngredience)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dlg_tfPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dlgMenuLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(dlg_btBack)
                        .addGap(42, 42, 42)
                        .addComponent(dlg_btOrder)
                        .addGap(38, 38, 38)
                        .addComponent(dlg_btPayment)
                        .addGap(45, 45, 45)
                        .addComponent(dlg_btDelete)))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        dlgMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dlg_cbDessert, dlg_cbDrink, dlg_cbMainCourse, dlg_cbStarter});

        dlgMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dlg_lblDessert, dlg_lblDrink, dlg_lblMainCourse, dlg_lblStarter});

        dlgMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dlg_lblImage, jScrollPane1});

        dlgMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dlg_btBack, dlg_btDelete, dlg_btOrder, dlg_btPayment});

        dlgMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dlg_lblIngredience, dlg_lblPrice});

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
                .addGap(36, 36, 36)
                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dlg_lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlg_lblIngredience1)
                    .addComponent(dlg_tfIngredience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlg_lblIngredience)
                    .addComponent(dlg_tfPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlg_lblPrice)
                    .addComponent(dlg_tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlg_lblCalorie)
                    .addComponent(dlg_tfCalorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlg_btBack)
                    .addComponent(dlg_btOrder)
                    .addComponent(dlg_btPayment)
                    .addComponent(dlg_btDelete))
                .addGap(28, 28, 28))
        );

        jLabel1.setText("Table NO:");

        jLabel2.setText("Pament Method");

        jLabel3.setText("Total");

        dlgPayment_tfTotal.setEditable(false);

        dlgPayment_cbMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Credit", "Debit", "Cash", "Cheque" }));

        dlgPayment_Save.setText("Save Transaction");
        dlgPayment_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgPayment_SaveActionPerformed(evt);
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
                            .addComponent(dlgPayment_tfTable)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgPaymentLayout.createSequentialGroup()
                        .addComponent(dlgPayment_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgPaymentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dlgPayment_lblCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addGap(45, 45, 45)
                .addComponent(dlgPayment_Save)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblWelcome.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblWelcome.setText("Welcome to swing Restaurent");

        btOrder.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(btOrder)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(btOrder)
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dlg_btOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlg_btOrderActionPerformed
    try {
            ArrayList<MenuDishOrder> ao=new ArrayList<>();
   MenuDishOrder a =new MenuDishOrder(dlg_lblFoodName.getText(),new BigDecimal(dlg_tfPrice.getText()));
    ao.add(a);
    
    for(MenuDishOrder addorder:ao){
    menuListModel.addElement(addorder);
    
    
    }
//    total=total.add(new BigDecimal(dlg_tfPrice.getText()));
 for(MenuDishOrder addItem:ao){
    total=total.add(addItem.price);
 }

            dlg_tfPayment.setText((String.valueOf(total)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Order your Dish order...",
                    "Select OneItem",
                    JOptionPane.ERROR_MESSAGE);

        } 
        
        
    
    
    dlg_tfIngredience.setText("");
    dlg_tfCalorie.setText("");
    dlg_tfPrice.setText("");
    dlg_lblFoodName.setText("");
    
    }//GEN-LAST:event_dlg_btOrderActionPerformed

    private void btOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOrderActionPerformed
        dlgMenu.pack();
        dlgMenu.setVisible(true);
        
    }//GEN-LAST:event_btOrderActionPerformed

    private void dlg_cbStarterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlg_cbStarterActionPerformed

        addToOrder((String) dlg_cbStarter.getSelectedItem());
                    
        ImageIcon iconLogo;

        switch  ((String) dlg_cbStarter.getSelectedItem()){
            
            case "Ceps":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\ceps.jpg");
                // In init() method write this code
                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  case "Truffle":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\truffle.jpg");
                // In init() method write this code
                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  case "FoieGras":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\foie.jpg");
                // In init() method write this code
                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  case "Pudding":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\pudding.jpg");
                // In init() method write this code
                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  
                  default:
                      iconLogo = new ImageIcon("img\\img.jpg");
        }
    }//GEN-LAST:event_dlg_cbStarterActionPerformed

    private void dlg_cbMainCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlg_cbMainCourseActionPerformed
        // TODO add your handling code here:
        addToOrder((String) dlg_cbMainCourse.getSelectedItem());
        
        switch  ((String) dlg_cbMainCourse.getSelectedItem()){
            
            case "Chicken":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\Chicken.jpg");
                // In init() method write this code
                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  case "Pork":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\pork.jpg");
                // In init() method write this code
                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  case "Duck":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\Duck.jpg");
                // In init() method write this code
                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  case "Fish":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\Fish.jpg");
                // In init() method write this codeDuck.jpg");

                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  
                  default:
                      iconLogo = new ImageIcon("img\\img.jpg");
        }
    }//GEN-LAST:event_dlg_cbMainCourseActionPerformed

    private void dlg_cbDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlg_cbDessertActionPerformed
        // TODO add your handling code here:
        addToOrder((String) dlg_cbDessert.getSelectedItem());
        switch  ((String) dlg_cbDessert.getSelectedItem()){
            
            case "Clafoutis":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\Clafoutis.jpg");
                // In init() method write this code
                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  case "Profiterole":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\Profiterole.jpg");
                // In init() method write this code
                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  case "Souffle":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\Souffle.jpg");
                // In init() method write this code
                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  case "Mousse":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\Mousse.jpg");
                // In init() method write this codeDuck.jpg");

                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  
                  default:
                      iconLogo = new ImageIcon("img\\img.jpg");
        }
    }//GEN-LAST:event_dlg_cbDessertActionPerformed

    private void dlg_cbDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlg_cbDrinkActionPerformed
        // TODO add your handling code here:(String) dlg_cbStarter.getSelectedItem()
        addToOrder((String) dlg_cbDrink.getSelectedItem());
        switch  ((String) dlg_cbDrink.getSelectedItem()){
        case "Martini":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\Martini.jpg");
                // In init() method cbDrinkwrite this code
                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  case "Lagoon":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\Lagoon.jpg");
                // In init() method write this code
                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  case "Serena":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\Serena.jpg");
                // In init() method write this code
                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  case "SeaBreeze":
                
                // Import ImageIcon     
                   iconLogo = new ImageIcon("img\\SeaBreeze.jpg");
                // In init() method write this codeDuck.jpg");

                  dlg_lblImage.setIcon(iconLogo);
                  break;
                  
                  default:
                      iconLogo = new ImageIcon("img\\img.jpg");
        }
    }//GEN-LAST:event_dlg_cbDrinkActionPerformed
int currIndex = -1;
    private void lstMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstMenuMouseReleased
        // TODO add your handling code here:
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
        currIndex = lstMenu.getSelectedIndex();
        if (currIndex == -1) {
            return;
        }
        
        total=total.subtract(menuListModel.getElementAt(currIndex).price);
        dlg_tfPayment.setText((String.valueOf(total)));
        menuListModel.remove(currIndex);
    }//GEN-LAST:event_dlg_btDeleteActionPerformed

    private void dlg_btPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlg_btPaymentActionPerformed
        // TODO add your handling code here:
        dlgPayment.pack();
        dlgPayment.setVisible(true);
        dlgPayment_tfTotal.setText((String.valueOf(total)));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        dlgPayment_lblCalendar.setText(dateFormat.format(cal.getTime()));
        
        
    }//GEN-LAST:event_dlg_btPaymentActionPerformed

    private void dlgPayment_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgPayment_SaveActionPerformed
        // TODO add your handling code here:
        String errors="";
        if (!dlgPayment_tfTable.getText().matches("^[0-9]{1,2}$")||(Integer.parseInt(dlgPayment_tfTable.getText())>30)) {
            errors += "* Enter Table Number between 1 and 30.\n";
        }
        if (dlgPayment_cbMethod.getSelectedItem()=="None") {
            errors += "* Select Payment Method\n";
        }
        //send
        if (errors.isEmpty()) {
            String line = String.format("Table no: %s; total: %s; Payment method: %s Dat&time %s"
                    , dlgPayment_tfTable.getText(),dlgPayment_tfTotal.getText(), dlgPayment_cbMethod.getSelectedItem(),dlgPayment_lblCalendar.getText());
            try {
                FileAccess.addTransactionToFile(line);
                dlgMenu.setVisible(false);
                dlgPayment.setVisible(false);
                menuListModel.removeAllElements();
                total=new BigDecimal(0);
                dlg_tfPayment.setText(" ");
                
            } catch (IOException ex) {
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
    private javax.swing.JDialog dlgMenu;
    private javax.swing.JDialog dlgPayment;
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
    private javax.swing.JLabel dlg_lblCalorie;
    private javax.swing.JLabel dlg_lblDessert;
    private javax.swing.JLabel dlg_lblDrink;
    private javax.swing.JLabel dlg_lblFoodName;
    private javax.swing.JLabel dlg_lblImage;
    private javax.swing.JLabel dlg_lblIngredience;
    private javax.swing.JLabel dlg_lblIngredience1;
    private javax.swing.JLabel dlg_lblMainCourse;
    private javax.swing.JLabel dlg_lblPrice;
    private javax.swing.JLabel dlg_lblStarter;
    private javax.swing.JTextField dlg_tfCalorie;
    private javax.swing.JTextField dlg_tfIngredience;
    private javax.swing.JTextField dlg_tfPayment;
    private javax.swing.JTextField dlg_tfPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JList<MenuDishOrder> lstMenu;
    // End of variables declaration//GEN-END:variables
}