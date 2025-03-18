package eventmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EventManagementSystem {

    private JFrame mainFrame;
    private List<String> bookingList;
    private List<String> venueList;
    private List<String> availableVenueList;

    public EventManagementSystem() {
        bookingList = new ArrayList<>();
        venueList = new ArrayList<>();
        availableVenueList = new ArrayList<>();
        venueList.add("East West Party Center");
        venueList.add("East West Auditorium");
        venueList.add("East West Playground");
        venueList.add("East West Yard");
        venueList.add("East West Community Center");
        availableVenueList.add("East West Party Center");
        availableVenueList.add("East West Auditorium");
        prepareMainInterface();
    }

    private void prepareMainInterface() {
        mainFrame = new JFrame("Event Management System");
        mainFrame.setSize(300, 250);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton adminLoginButton = new JButton("Admin Login");
        JButton customerLoginButton = new JButton("Customer Login");
        JButton createAccountButton = new JButton("Create Account");
        JButton othersButton = new JButton("Others");
        adminLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAdminLoginFrame();
            }
        });
        customerLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showCustomerLoginFrame();
            }
        });
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showCreateAccountFrame();
            }
        });
        othersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showOthersFrame();
            }
        });
        mainFrame.setLayout(new GridLayout(4, 1, 10, 10));
        mainFrame.add(adminLoginButton);
        mainFrame.add(customerLoginButton);
        mainFrame.add(createAccountButton);
        mainFrame.add(othersButton);
        mainFrame.setVisible(true);
    }

    private void showAdminLoginFrame() {
        JFrame adminLoginFrame = new JFrame("Admin Login");
        adminLoginFrame.setSize(300, 200);
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (username.equals("Prome") && password.equals("javaproject")) {
                    showAdminPanelFrame();
                } else {
                    JOptionPane.showMessageDialog(adminLoginFrame, "Incorrect username or password!");
                }
            }
        });
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminLoginFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        adminLoginFrame.setLayout(new GridLayout(4, 1, 10, 10));
        adminLoginFrame.add(new JLabel("Username:"));
        adminLoginFrame.add(usernameField);
        adminLoginFrame.add(new JLabel("Password:"));
        adminLoginFrame.add(passwordField);
        adminLoginFrame.add(new JLabel());
        adminLoginFrame.add(loginButton);
        adminLoginFrame.add(new JLabel());
        adminLoginFrame.add(backButton);
        adminLoginFrame.setVisible(true);
        mainFrame.setVisible(false);
    }

    private void showAdminPanelFrame() {
        JFrame adminPanelFrame = new JFrame("Admin Panel");
        adminPanelFrame.setSize(400, 300);
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminPanelFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        JButton viewBookingListButton = new JButton("View Booking List");
        viewBookingListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showBookingList(adminPanelFrame);
            }
        });
        adminPanelFrame.setLayout(new GridLayout(4, 1, 10, 10));
        adminPanelFrame.add(viewBookingListButton);
        adminPanelFrame.add(new JButton("Delete Booking"));
        adminPanelFrame.add(new JButton("Reply"));
        adminPanelFrame.add(backButton);
        adminPanelFrame.setVisible(true);
        mainFrame.setVisible(false);
    }

    private void showBookingList(JFrame parentFrame) {
       JFrame bookingListFrame = new JFrame("Booking List");
        bookingListFrame.setSize(400, 300);
        String[] header = {"Event Name", "Date"};
        String[][] data = new String[bookingList.size()][2];
        for (int i = 0; i < bookingList.size(); i++) {
            String[] event = bookingList.get(i).split(",");
            String name = event[0].split(":")[1].trim();
            String date = event[1].split(":")[1].trim();
            data[i][0] = name;
            data[i][1] = date;
        }
        JTable table = new JTable(data, header);
        bookingListFrame.add(new JScrollPane(table));
        bookingListFrame.setVisible(true);

    }

    private void showCustomerLoginFrame() {
        JFrame customerLoginFrame = new JFrame("Customer Login");
        customerLoginFrame.setSize(300, 200);
        JTextField usernameField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String pass = new String(passField.getPass());
                if (username.equals("Prome") && pass.equals("project")) {
                    showCustomerPanelFrame();
                } else {
                    JOptionPane.showMessageDialog(customerLoginFrame, "Incorrect username or password!");
                }
            }
        });
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                customerLoginFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        customerLoginFrame.setLayout(new GridLayout(4, 2, 10, 10));
        customerLoginFrame.add(new JLabel("Username:"));
        customerLoginFrame.add(usernameField);
        customerLoginFrame.add(new JLabel("Pass:"));
        customerLoginFrame.add(passField);
        customerLoginFrame.add(new JLabel());
        customerLoginFrame.add(loginButton);
        customerLoginFrame.add(new JLabel());
        customerLoginFrame.add(backButton);
        customerLoginFrame.setVisible(true);
        mainFrame.setVisible(false);
    }

    private void showCustomerPanelFrame() {
        JFrame customerPanelFrame = new JFrame("Customer Panel");
        customerPanelFrame.setSize(400, 300);
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                customerPanelFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        JButton viewVenueButton = new JButton("View Venue");
        viewVenueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showVenueList(customerPanelFrame);
            }
        });
        JButton viewAvailableVenueButton = new JButton("View Available Venue List");
        viewAvailableVenueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAvailableVenueList(customerPanelFrame);
            }
        });
        JButton bookEventButton = new JButton("Book Event");
        bookEventButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showEventBookingFrame();
            }
        });
        customerPanelFrame.setLayout(new GridLayout(5, 1, 10, 10));
        customerPanelFrame.add(viewVenueButton);
        customerPanelFrame.add(viewAvailableVenueButton);
        customerPanelFrame.add(new JButton("Venue Price List"));
        customerPanelFrame.add(bookEventButton);
        customerPanelFrame.add(backButton);
        customerPanelFrame.setVisible(true);
        mainFrame.setVisible(false);
    }

    private void showVenueList(JFrame parentFrame) {
        StringBuilder sb = new StringBuilder();
        for (String venue : venueList) {
            sb.append(venue).append("\n");
        }
        JOptionPane.showMessageDialog(parentFrame, sb.toString(), "Venue List", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showAvailableVenueList(JFrame parentFrame) {
        StringBuilder sb = new StringBuilder();
        for (String venue : availableVenueList) {
            sb.append(venue).append("\n");
        }
        JOptionPane.showMessageDialog(parentFrame, sb.toString(), "Available Venue List", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showEventBookingFrame() {
        JFrame eventBookingFrame = new JFrame("Event Booking");
        eventBookingFrame.setSize(400, 300);
        JTextField eventNameField = new JTextField();
        JTextField eventDateField = new JTextField();
        JButton bookEventButton = new JButton("Book Event");
        bookEventButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String eventName = eventNameField.getText();
                String eventDate = eventDateField.getText();
           
                bookingList.add("Event Name: " + eventName + ", Event Date: " + eventDate);
                JOptionPane.showMessageDialog(eventBookingFrame, "Event booked successfully!");
                eventNameField.setText("");
                eventDateField.setText("");
            }
        });
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventBookingFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        eventBookingFrame.setLayout(new GridLayout(5, 2, 10, 10));
        eventBookingFrame.add(new JLabel("Event Name:"));
        eventBookingFrame.add(eventNameField);
        eventBookingFrame.add(new JLabel("Event Date:"));
        eventBookingFrame.add(eventDateField);
        eventBookingFrame.add(new JLabel());
        eventBookingFrame.add(bookEventButton);
        eventBookingFrame.add(new JLabel());
        eventBookingFrame.add(backButton);
        eventBookingFrame.setVisible(true);
        mainFrame.setVisible(false);
    }

    private void showCreateAccountFrame() {
        JFrame createAccountFrame = new JFrame("Create Account");
        createAccountFrame.setSize(300, 200);
        JTextField usernameField = new JTextField();
        JPasswordField passField = new JPassField();
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                JOptionPane.showMessageDialog(createAccountFrame, "Account created successfully!");
                createAccountFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createAccountFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        createAccountFrame.setLayout(new GridLayout(4, 2, 10, 10));
        createAccountFrame.add(new JLabel("Username:"));
        createAccountFrame.add(usernameField);
        createAccountFrame.add(new JLabel("Password:"));
        createAccountFrame.add(passwordField);
        createAccountFrame.add(new JLabel());
        createAccountFrame.add(createAccountButton);
        createAccountFrame.add(new JLabel());
        createAccountFrame.add(backButton);
        createAccountFrame.setVisible(true);
        mainFrame.setVisible(false);
    }

    private void showOthersFrame() {
        JFrame othersFrame = new JFrame("Others");
        othersFrame.setSize(300, 200);
        JButton aboutUsButton = new JButton("About Us");
        aboutUsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(othersFrame, "This is the Event Management System created by Prome.", "About Us", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JButton contactUsButton = new JButton("Contact Us");
        contactUsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(othersFrame, "You can contact us at prome@exa.com.", "Contact Us", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                othersFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        othersFrame.setLayout(new GridLayout(4, 1, 10, 10));
        othersFrame.add(aboutUsButton);
        othersFrame.add(contactUsButton);
        othersFrame.add(new JButton("Help"));
        othersFrame.add(backButton);
        othersFrame.setVisible(true);
        mainFrame.setVisible(false);
    }

    public static void main(String[] args) {
        EventManagementSystem eventManagementSystem = new EventManagementSystem();
    }
}
