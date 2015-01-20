package dtu02324.server.dal;

import java.util.HashMap;

import dtu02324.shared.OprDTO;

public class OprDAO {
	private static int next_id = 10;
	private static OprDAO instance = new OprDAO();
	private HashMap<Integer, OprDTO> operators = new HashMap<Integer, OprDTO>(); 
	
	private OprDAO(){ 
		createOperators();
	}
	
	private void createOperators() {
		addOpr(new OprDTO("Stig", "1234567890", "02324it!"));		
		addOpr(new OprDTO("Mads", "1234567890", "02324it!"));		
		addOpr(new OprDTO("Daniel", "1234567890", "02324it!"));
		
		for(int key : operators.keySet()){
			System.out.println(key + " -> " + operators.get(key));
		}
	}

	public static OprDAO getInstance(){ return instance; }

//	public static int getNextID() { return next_id++; }
	public void addOpr(OprDTO opr){
		int id = opr.getId();
		if(id == -1) id = OprDAO.next_id++;
		opr.setId(id);
		operators.put(id, opr);
	}
	public OprDTO getOpr(int id){
		return operators.get(id);
	}
	
}
