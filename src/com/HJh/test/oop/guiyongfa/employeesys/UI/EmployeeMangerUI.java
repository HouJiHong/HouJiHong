package com.HJh.test.oop.guiyongfa.employeesys.UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 员工信息管理系统主界面
 */
public class EmployeeMangerUI extends JFrame {

    private JTextField searchField;
    private JButton searchBtn;
    private JButton addBtn;
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private JPopupMenu popupMenu;

    // 员工数据列表
    private static List<Employee> employeeList;

    // 表格列名
    private final String[] columnNames = {"员工编号", "姓名", "性别", "部门", "职位", "手机号", "入职日期", "薪资"};

    public EmployeeMangerUI() {
    }
    public EmployeeMangerUI(String  user) {
        super("欢迎 "+user+" 进入人事系统！");
        employeeList = new ArrayList<>();
        initData(); // 初始化20条数据
        initUI();
    }


    /**
     * 初始化20条员工数据
     */
    private void initData() {
        String[][] rawData = {
                {"EMP001", "张三", "男", "技术部", "Java工程师", "13800138001", "2020-03-15", "15000"},
                {"EMP002", "李四", "女", "技术部", "前端工程师", "13800138002", "2019-06-20", "14000"},
                {"EMP003", "王五", "男", "产品部", "产品经理", "13800138003", "2018-09-10", "18000"},
                {"EMP004", "赵六", "女", "测试部", "测试工程师", "13800138004", "2021-01-08", "12000"},
                {"EMP005", "孙七", "男", "运维部", "运维工程师", "13800138005", "2020-07-22", "13000"},
                {"EMP006", "周八", "女", "人事部", "HR专员", "13800138006", "2019-11-30", "10000"},
                {"EMP007", "吴九", "男", "财务部", "会计", "13800138007", "2017-05-18", "11000"},
                {"EMP008", "郑十", "女", "技术部", "架构师", "13800138008", "2016-08-25", "25000"},
                {"EMP009", "钱十一", "男", "销售部", "销售经理", "13800138009", "2020-02-14", "16000"},
                {"EMP010", "冯十二", "女", "市场部", "市场专员", "13800138010", "2021-04-01", "9500"},
                {"EMP011", "陈十三", "男", "技术部", "Python工程师", "13800138011", "2020-10-12", "14500"},
                {"EMP012", "褚十四", "女", "设计部", "UI设计师", "13800138012", "2019-03-28", "13500"},
                {"EMP013", "卫十五", "男", "技术部", "DevOps工程师", "13800138013", "2021-06-15", "15500"},
                {"EMP014", "蒋十六", "女", "运营部", "运营专员", "13800138014", "2020-09-09", "10500"},
                {"EMP015", "沈十七", "男", "技术部", "技术总监", "13800138015", "2015-12-01", "35000"},
                {"EMP016", "韩十八", "女", "客服部", "客服主管", "13800138016", "2018-07-19", "11500"},
                {"EMP017", "杨十九", "男", "采购部", "采购专员", "13800138017", "2022-01-10", "9000"},
                {"EMP018", "朱二十", "女", "法务部", "法务专员", "13800138018", "2021-08-23", "13000"},
                {"EMP019", "秦二一", "男", "技术部", "全栈工程师", "13800138019", "2019-05-07", "17000"},
                {"EMP020", "尤二二", "女", "行政部", "行政助理", "13800138020", "2022-03-30", "8000"}
        };

        for (String[] row : rawData) {
            employeeList.add(new Employee(row[0], row[1], row[2], row[3], row[4], row[5], row[6], Double.parseDouble(row[7])));
        }
    }

    /**
     * 初始化界面
     */
    private void initUI() {

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ===== 顶部面板：搜索框 + 搜索按钮 + 添加按钮（居中） =====
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JLabel searchLabel = new JLabel("搜索:");
        searchField = new JTextField(20);
        searchBtn = new JButton("🔍 搜索");
        addBtn = new JButton("➕ 添加员工");

        // 设置按钮样式
        searchBtn.setFocusPainted(false);
        addBtn.setFocusPainted(false);
        addBtn.setBackground(new Color(70, 130, 180));
        addBtn.setForeground(Color.WHITE);

        topPanel.add(searchLabel);
        topPanel.add(searchField);
        topPanel.add(searchBtn);
        topPanel.add(addBtn);

        add(topPanel, BorderLayout.NORTH);

        // ===== 中部面板：表格 =====
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 表格不可直接编辑
            }
        };

        employeeTable = new JTable(tableModel);
        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeTable.setRowHeight(28);
        employeeTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        employeeTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 13));
        employeeTable.getTableHeader().setBackground(new Color(240, 240, 240));

        // 设置列宽
        employeeTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        employeeTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        employeeTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        employeeTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        employeeTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        employeeTable.getColumnModel().getColumn(5).setPreferredWidth(120);
        employeeTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        employeeTable.getColumnModel().getColumn(7).setPreferredWidth(80);

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);

        // 加载数据到表格
        refreshTable();

        // ===== 右键菜单 =====
        popupMenu = new JPopupMenu();// 创建右键菜单
        JMenuItem editItem = new JMenuItem("✏️ 修改");
        JMenuItem deleteItem = new JMenuItem("🗑️ 删除");
        popupMenu.add(editItem);// 添加修改菜单项
        popupMenu.addSeparator();// 添加分割线
        popupMenu.add(deleteItem);// 添加删除菜单项

        // 表格右键监听
        employeeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }// 鼠标按下时显示右键菜单

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }// 鼠标释放时显示右键菜单

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int row = employeeTable.rowAtPoint(e.getPoint());// 获取点击的行索引
                    if (row >= 0) {
                        employeeTable.setRowSelectionInterval(row, row);// 选中行
                        popupMenu.show(employeeTable, e.getX(), e.getY());// 显示右键菜单
                    }
                }
            }
        });

        // ===== 事件绑定 =====
        searchBtn.addActionListener(e -> searchEmployee());
        addBtn.addActionListener(e -> showAddDialog());
        editItem.addActionListener(e -> showEditDialog());
        deleteItem.addActionListener(e -> deleteEmployee());

        // 搜索框回车事件
        searchField.addActionListener(e -> searchEmployee());

        // 双击行也可以修改
        employeeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
                    showEditDialog();
                }
            }
        });

    }

    /**
     * 刷新表格数据
     */
    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Employee emp : employeeList) {
            tableModel.addRow(emp.toArray());
        }
    }

    /**
     * 搜索员工
     */
    private void searchEmployee() {
        String keyword = searchField.getText().trim().toLowerCase();
        if (keyword.isEmpty()) {
            refreshTable();
            return;
        }

        tableModel.setRowCount(0);
        for (Employee emp : employeeList) {
            if (emp.getName().toLowerCase().contains(keyword) ||
                    emp.getId().toLowerCase().contains(keyword) ||
                    emp.getDept().toLowerCase().contains(keyword) ||
                    emp.getPhone().contains(keyword)) {
                tableModel.addRow(emp.toArray());
            }
        }

        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "未找到匹配的员工信息", "提示", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        }
    }

    /**
     * 显示添加对话框
     */
    private void showAddDialog() {
        EmployeeDialog dialog = new EmployeeDialog(this, "添加员工", null);
        dialog.setVisible(true);
        Employee newEmp = dialog.getEmployee();
        if (newEmp != null) {
            employeeList.add(newEmp);
            refreshTable();
            JOptionPane.showMessageDialog(this, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * 显示修改对话框
     */
    private void showEditDialog() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "请先选择要修改的员工", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = (String) tableModel.getValueAt(selectedRow, 0);
        Employee emp = findEmployeeById(id);
        if (emp == null) return;

        EmployeeDialog dialog = new EmployeeDialog(this, "修改员工", emp);
        dialog.setVisible(true);
        Employee updated = dialog.getEmployee();
        if (updated != null) {
            emp.updateFrom(updated);
            refreshTable();
            JOptionPane.showMessageDialog(this, "修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * 删除员工
     */
    private void deleteEmployee() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "请先选择要删除的员工", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = (String) tableModel.getValueAt(selectedRow, 0);
        String name = (String) tableModel.getValueAt(selectedRow, 1);

        int confirm = JOptionPane.showConfirmDialog(this,
                "确定要删除员工 [" + name + "] 吗？此操作不可恢复！",
                "确认删除",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            employeeList.removeIf(e -> e.getId().equals(id));
            refreshTable();
            JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private Employee findEmployeeById(String id) {
        for (Employee e : employeeList) {
            if (e.getId().equals(id)) return e;
        }
        return null;
    }

    // ==================== 员工实体类 ====================
    public static class Employee {
        private String id;
        private String name;
        private String gender;
        private String dept;
        private String position;
        private String phone;
        private String hireDate;
        private double salary;

        public Employee(String id, String name, String gender, String dept,
                        String position, String phone, String hireDate, double salary) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.dept = dept;
            this.position = position;
            this.phone = phone;
            this.hireDate = hireDate;
            this.salary = salary;
        }

        public void updateFrom(Employee other) {
            this.name = other.name;
            this.gender = other.gender;
            this.dept = other.dept;
            this.position = other.position;
            this.phone = other.phone;
            this.hireDate = other.hireDate;
            this.salary = other.salary;
        }

        public Object[] toArray() {
            return new Object[]{id, name, gender, dept, position, phone, hireDate, String.format("%.2f", salary)};
        }

        // Getters & Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }
        public String getDept() { return dept; }
        public void setDept(String dept) { this.dept = dept; }
        public String getPosition() { return position; }
        public void setPosition(String position) { this.position = position; }
        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }
        public String getHireDate() { return hireDate; }
        public void setHireDate(String hireDate) { this.hireDate = hireDate; }
        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }
    }

    // ==================== 添加/修改对话框 ====================
    public static class EmployeeDialog extends JDialog {
        private Employee employee;
        private boolean confirmed = false;

        private JTextField idField, nameField, phoneField, hireDateField, salaryField;
        private JComboBox<String> genderBox, deptBox, positionBox;

        public EmployeeDialog(JFrame parent, String title, Employee emp) {
            super(parent, title, true);
            this.employee = emp;
            initDialog();
            setSize(400, 400);
            setLocationRelativeTo(parent);
        }

        private void initDialog() {
            JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            idField = new JTextField();
            nameField = new JTextField();
            genderBox = new JComboBox<>(new String[]{"男", "女"});
            deptBox = new JComboBox<>(new String[]{"技术部", "产品部", "测试部", "运维部", "人事部", "财务部", "销售部", "市场部", "设计部", "运营部", "客服部", "采购部", "法务部", "行政部"});
            positionBox = new JComboBox<>(new String[]{"Java工程师", "前端工程师", "Python工程师", "全栈工程师", "架构师", "技术总监", "产品经理", "测试工程师", "运维工程师", "DevOps工程师", "UI设计师", "HR专员", "会计", "销售经理", "市场专员", "运营专员", "客服主管", "采购专员", "法务专员", "行政助理"});
            phoneField = new JTextField();
            hireDateField = new JTextField();
            salaryField = new JTextField();

            if (employee != null) {
                idField.setText(employee.getId());
                idField.setEditable(false);
                nameField.setText(employee.getName());
                genderBox.setSelectedItem(employee.getGender());
                deptBox.setSelectedItem(employee.getDept());
                positionBox.setSelectedItem(employee.getPosition());
                phoneField.setText(employee.getPhone());
                hireDateField.setText(employee.getHireDate());
                salaryField.setText(String.valueOf(employee.getSalary()));
            } else {
                // 自动生成编号
                idField.setText("EMP" + String.format("%03d", (int)(Math.random() * 900 + 100)));
                idField.setEditable(false);
                hireDateField.setText(java.time.LocalDate.now().toString());
            }

            panel.add(new JLabel("员工编号:")); panel.add(idField);
            panel.add(new JLabel("姓名:")); panel.add(nameField);
            panel.add(new JLabel("性别:")); panel.add(genderBox);
            panel.add(new JLabel("部门:")); panel.add(deptBox);
            panel.add(new JLabel("职位:")); panel.add(positionBox);
            panel.add(new JLabel("手机号:")); panel.add(phoneField);
            panel.add(new JLabel("入职日期:")); panel.add(hireDateField);
            panel.add(new JLabel("薪资:")); panel.add(salaryField);

            // 按钮面板
            JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
            JButton confirmBtn = new JButton("确定");
            JButton cancelBtn = new JButton("取消");
            confirmBtn.setBackground(new Color(70, 130, 180));
            confirmBtn.setForeground(Color.WHITE);
            btnPanel.add(confirmBtn);
            btnPanel.add(cancelBtn);

            add(panel, BorderLayout.CENTER);
            add(btnPanel, BorderLayout.SOUTH);

            confirmBtn.addActionListener(e -> {
                if (nameField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "姓名不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    double salary = Double.parseDouble(salaryField.getText().trim());
                    employee = new Employee(
                            idField.getText().trim(),
                            nameField.getText().trim(),
                            (String) genderBox.getSelectedItem(),
                            (String) deptBox.getSelectedItem(),
                            (String) positionBox.getSelectedItem(),
                            phoneField.getText().trim(),
                            hireDateField.getText().trim(),
                            salary
                    );
                    confirmed = true;
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "薪资必须为数字！", "错误", JOptionPane.ERROR_MESSAGE);
                }
            });

            cancelBtn.addActionListener(e -> dispose());
        }

        public Employee getEmployee() {
            return confirmed ? employee : null;
        }
    }

//    public static void main(String[] args) {
//        // 设置系统外观
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception ignored) {}
//
//        SwingUtilities.invokeLater(() -> {
//            EmployeeMangerUI app = new EmployeeMangerUI();
//            app.setVisible(true);
//        });
//    }
}