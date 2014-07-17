package ui;

import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.DataModel;

public class MainFrame {

	private JFrame mJFrame = null;
	private Container mContainer = null;
	
	private ScrollEditText mSourceTextField;
	private ScrollEditText mResultTextField;
	private JButton mMakeJButton = null;

	private JTextField mDeleteGeJTextField = null;
	private JTextField mDeleteShiJTextField = null;
	private JTextField mDeleteBaiJTextField = null;

	public MainFrame(){
		initFrame();
		initTextField();
		initMakeJButton();
		initDeleteLabel();
	}

	private void initFrame(){
		mJFrame = new JFrame(AppStrings.Frame_Title);
		mJFrame.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
 
            public void windowActivated(WindowEvent e) { 
            
            }  
        }); 
		mJFrame.setResizable(false);  
		mJFrame.setSize(AppFrameSize.MAIN_FRAME_W, AppFrameSize.MAIN_FRAME_W);
		mContainer = mJFrame.getContentPane();
		mContainer.setLayout(null);
	}

	private void initTextField(){
		mSourceTextField = new ScrollEditText(10, 15);
		mResultTextField = new ScrollEditText(10, 15);

		mSourceTextField.getJScrollPane().setBounds(AppFrameSize.SOURCE_TEXTFEILD_Rectangle);
		mResultTextField.getJScrollPane().setBounds(AppFrameSize.RESULT_TEXTFEILD_Rectangle);
		mContainer.add(mSourceTextField.getJScrollPane());
		mContainer.add(mResultTextField.getJScrollPane());
	}

	
	private void initMakeJButton(){
		mMakeJButton = new JButton(AppStrings.BUTTON_MAKE);
		mMakeJButton.setBounds(AppFrameSize.BUTTON_MAKE_Rectangle);
		mContainer.add(mMakeJButton);
		mMakeJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				makeData();
			}
		});
	}

	private void initDeleteLabel(){
		JLabel titleLabel = new JLabel(AppStrings.Label_Delete);
		titleLabel.setBounds(AppFrameSize.LABEL_DELETE_TITLE_Rectangle);
		mContainer.add(titleLabel);
		
		JLabel titleGeLabel = new JLabel(AppStrings.Label_gewei);
		titleGeLabel.setBounds(AppFrameSize.LABEL_DELETE_TITLE_GE_Rectangle);
		mContainer.add(titleGeLabel);

		JLabel titleShiLabel = new JLabel(AppStrings.Label_shiwei);
		titleShiLabel.setBounds(AppFrameSize.LABEL_DELETE_TITLE_SHI_Rectangle);
		mContainer.add(titleShiLabel);
		
		JLabel titleBaiLabel = new JLabel(AppStrings.Label_baiwei);
		titleBaiLabel.setBounds(AppFrameSize.LABEL_DELETE_TITLE_BAI_Rectangle);
		mContainer.add(titleBaiLabel);

		mDeleteGeJTextField = getJTextField(AppFrameSize.EDIT_DELETE_GE_Rectangle);
		mDeleteShiJTextField = getJTextField(AppFrameSize.EDIT_DELETE_SHI_Rectangle);
		mDeleteBaiJTextField = getJTextField(AppFrameSize.EDIT_DELETE_BAI_Rectangle);
		mContainer.add(mDeleteGeJTextField);
		mContainer.add(mDeleteShiJTextField);
		mContainer.add(mDeleteBaiJTextField);
	}

	private JTextField getJTextField(Rectangle r){
		JTextField textField= new JTextField();
		textField.setBounds(r);
		return textField;
	}

	public void show() {  
		mJFrame.setVisible(true);
    }

	private void makeData(){
		System.out.println();
		String resData = mSourceTextField.getText();
		String geStr = mDeleteGeJTextField.getText();
		String shiStr = mDeleteShiJTextField.getText();
		String baiStr = mDeleteBaiJTextField.getText();
		String qianStr = null;
		String wanStr = null;
		System.out.println(resData);
		System.out.println(geStr);
		System.out.println(shiStr);
		System.out.println(baiStr);
	
		DataModel dataModel = new DataModel();
		dataModel.setResoureData(resData);
		dataModel.setDeleteData(geStr, shiStr, baiStr, qianStr, wanStr);

		mResultTextField.setText(dataModel.getResultData());
	}
}
