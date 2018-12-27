package day1212;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Design class와 Has a관계로 설정된 이벤트 처리 클래스
 * @author owner
 */
public class FriendsListEvt extends WindowAdapter implements ActionListener,ItemListener{

	private FriendsList fl;
	//이벤트를 처리하기 위해 사용되는 모든 컴포넌트는 has a관계의 객체를 사용하여 처리한다.
	
	public FriendsListEvt(FriendsList fl) {
		this.fl=fl;
	}//FriendsListEvt
	
	@Override
	public void windowClosing(WindowEvent e) {
		fl.dispose();
	}//windowClosing
	
	@Override
	//List 이벤트 처리
	public void itemStateChanged(ItemEvent ie) {
		//친구 리스트에서 클릭되면 해당 아이템을 차단된 친구로 보낸다.
		if(ie.getSource()==fl.getListFriend()) {
//			System.out.println("친구");
			blockFriend();
		}
		//차단된 친구 리스트에서 클릭된 해당 아이템을 친구 리스트로 보낸다.
		if(ie.getSource()==fl.getListBlockFriend()) {
//			System.out.println("친구도 아님");
			unblockFriend();
		}
	}//itemStateChanged

	@Override
	//Button 이벤트 처리
	public void actionPerformed(ActionEvent ae) {
		//>> : 모든친구를 차단 목록으로 이동
		if(ae.getSource()==fl.getBtnAllBlock()) {
			allBlock();
		}//end if
		//<< : 차단된 모든 친구를 친구목록으로 이동
		if(ae.getSource()==fl.getBtnAllUnBlock()) {
			allUnBlock();
		}//end if
	}//actionPerformed
	
	/**
	 * 친구 리스트에서 선택한 친구를 차단 리스트로 이동
	 */
	private void blockFriend() {
		List tempFriend=fl.getListFriend();
		//선택한 친구를 얻어와서
		String name=tempFriend.getSelectedItem();
		//차단으로 보낸다.
		fl.getListBlockFriend().add(name);
		//선택한 친구를 삭제
		tempFriend.remove(name);
	}//blockFriend

	/**
	 * 차단한 친구 리스트에서 선택한 친구를 친구 리스트로 이동.
	 */
	private void unblockFriend() {
		//차단된 친구리스트에서 선택한 친구를 받아와서
		List tempList=fl.getListBlockFriend();
		int selectedIndex=tempList.getSelectedIndex();
		//친구 리스트에 추가하고
		fl.getListFriend().add(tempList.getItem(selectedIndex));
		//차단된 친구리스트에서 삭제한다.
		tempList.remove(selectedIndex);
		
	}//unblockFriend
	
	/**
	 * &gt;&gt; 버튼을 클릭하면 모든 친구 차단
	 */
	private void allBlock() {
		//친구리스트의 모든 아이템을 받아와서
		String[] arrfriend= fl.getListFriend().getItems();
		//<list에 있는 getItems() 모두 받는다.
		//차단리스트로 보낸다.
		for(int i=0; i<arrfriend.length; i++) {
			fl.getListBlockFriend().add(arrfriend[i]);
		}//end for
		//<차단을 풀은 친구들을 모두 삭제
		//친구리스트의 모든 아이템을 삭제
		fl.getListFriend().removeAll();
		
	}//allBlock
	
	/**
	 * &lt;&lt; 버튼을 클릭하면 차단된 모든 친구가 친구 리스트로 이동
	 */
	private void allUnBlock() {
		//차단된 모든 친구목록을 받아와서
		String[] arrBlockList=fl.getListBlockFriend().getItems();
		//친구목록에 추가하고
		for(String name : arrBlockList) {
			fl.getListFriend().add(name);
		}
		//차단된 모든 친구목록을 삭제
		fl.getListBlockFriend().removeAll();
		
	}//allUnBlock
	
}//class
