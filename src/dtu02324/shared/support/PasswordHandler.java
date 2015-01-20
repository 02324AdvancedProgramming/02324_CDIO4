package dtu02324.shared.support;

import java.util.ArrayList;
import java.util.Random;

public class PasswordHandler {
	private static final int MIN_PASSWORD_LENGTH = 6;
	private static ArrayList<Character> lowers, uppers, numbers, specials;
	static{
		lowers = new ArrayList<Character>();
		uppers = new ArrayList<Character>();
		numbers = new ArrayList<Character>();
		specials = new ArrayList<Character>(); 
		for(int i = 0; i <= 'z'-'a'; i++){
			lowers.add((char)('a'+i));
			uppers.add((char)('A'+i));
		}
		for(int i = 0; i <= '9' - '0'; i++){
			numbers.add((char)('0'+i));
		}
		for(char c : new char[] {'.', '-', '_', '+', '!', '?', '='}){
			specials.add(c);
		}
	}
	
	private static Random rand = new Random();
	
	/**
	 * Creates a new String with length [6-10]
	 * Every password contains one of each of:
	 * [a-z], [A-Z], [0-9], {., -, _, +, !, ?, =}
	 * The password is completed with random 
	 * characters form any of the groups.
	 * @return
	 */
	public static String generatePassword(){
		ArrayList<Character> password = new ArrayList<Character>();
		password.add(lowers.get(rand.nextInt(lowers.size())));
		password.add(uppers.get(rand.nextInt(uppers.size())));
		password.add(numbers.get(rand.nextInt(numbers.size())));
		password.add(specials.get(rand.nextInt(specials.size())));
		
		int total_chars = lowers.size() + uppers.size()
				+ numbers.size() + specials.size();
		
		int length = rand.nextInt(5)+6;
		for(int i = 4; i < length; i++){
			int index = rand.nextInt(total_chars); 
			if(index < lowers.size()){ password.add(lowers.get(index)); continue; }
			index -= lowers.size(); 
			if(index < uppers.size()){ password.add(uppers.get(index)); continue; }
			index -= uppers.size(); 
			if(index < numbers.size()){ password.add(numbers.get(index)); continue; }
			index -= numbers.size(); 
			if(index > specials.size()) throw new IndexOutOfBoundsException("Programmer error");
			password.add(specials.get(index));
		}
		GWT_Collections.shuffle(password);
		StringBuilder builder = new StringBuilder();
		for(Character c : password){
			builder.append(c);
		}
		
		String _password = builder.toString();
		if(!validatePassword(_password)){
			throw new RuntimeException("Programmmer error - generated invalid password!");
		}
		return _password;
	}
	
	public static boolean validatePassword(String password) {
		if(password.length() < MIN_PASSWORD_LENGTH) return false;
		boolean hasLower = false, hasUpper = false, hasNumbers = false, hasSpecials = false;
		ArrayList<Character> chars = new ArrayList<Character>();
		for(char c : password.toCharArray()) chars.add(c);

		for(char c : lowers) if(password.indexOf(c) >= 0) hasLower = true;
		for(char c : uppers) if(password.indexOf(c) >= 0) hasUpper = true;
		for(char c : numbers) if(password.indexOf(c) >= 0) hasNumbers = true;
		for(char c : specials) if(password.indexOf(c) >= 0) hasSpecials = true;
		
		int counter = 0;
		if(hasLower) counter++;
		if(hasUpper) counter++;
		if(hasNumbers) counter++;
		if(hasSpecials) counter++;
		return counter >= 3;
	}
	
	public static void main(String[] args) {
		
	}
}
