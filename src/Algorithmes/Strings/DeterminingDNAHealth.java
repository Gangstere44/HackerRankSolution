package Algorithmes.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;

public class DeterminingDNAHealth {
	
	static HashMap<String, Integer> transition = new HashMap<>();
	static HashMap<Integer, HashSet<Character>> vocab = new HashMap<>();
	static HashMap<Integer, Integer> fallback = new HashMap<>();
	static HashMap<Integer, HashMap<Integer, Integer>> output = new HashMap<>();
	
	static int stateCounter = 1;
	
	static void addWord(char[] w, int idx, int health) {
		int state = 0; // root
		
		for(char c: w) {
			if(!vocab.containsKey(state))
				vocab.put(state, new HashSet<Character>());
			vocab.get(state).add(c);
			
			if(!transition.containsKey(state+"_"+c))
					transition.put(state+"_"+c, stateCounter++);
			state = transition.get(state+"_"+c);
		}
		
		if(!output.containsKey(state))
			output.put(state, new HashMap<Integer, Integer>());
		output.get(state).put(idx, health);
	}
	
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] gs = br.readLine().split(" ");
		String[] hs = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			addWord(gs[i].toCharArray(), i, Integer.parseInt(hs[i]));
		}
		// aho cosarick construction
		LinkedList<Integer> toVisit = new LinkedList<>();
		for(char c: vocab.get(0))
			toVisit.add(transition.get("0_"+c));
		
		while(!toVisit.isEmpty()) {
			int state = toVisit.poll();
			
			for(char c: vocab.getOrDefault(state, new HashSet<Character>())) {
				
				if(!fallback.containsKey(state))
					fallback.put(state, 0);
				
				int t = fallback.get(state);
				while(t > 0 && !transition.containsKey(t+"_"+c)) {
					if(!fallback.containsKey(state))
						fallback.put(state, 0);
					t = fallback.get(state);
				}
				
				if(!transition.containsKey(state+"_"+c))
					transition.put(state+"_"+c, stateCounter++);
				int s = transition.get(state+"_"+c);
				
				fallback.put(s, transition.containsKey(t+"_"+c) ? transition.get(t+"_"+c) : 0);
				
				if(!output.containsKey(state))
					output.put(state, new HashMap<Integer, Integer>());
				if(!output.containsKey(fallback.get(s)))
					output.put(fallback.get(s), new HashMap<Integer, Integer>());
				output.get(state).putAll(output.get(fallback.get(s)));
				
				toVisit.add(s);
			}
		}
		
		// query
		long max = 0;
		long min = Long.MAX_VALUE;
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			
			String[] tmp = br.readLine().split(" ");
			int l = Integer.parseInt(tmp[0]);
			int r = Integer.parseInt(tmp[1]);
			char[] word = tmp[2].toCharArray();
			
			long sum = 0;
			int state = 0;
			for(char c: word) {
				
				while(state > 0 && !transition.containsKey(state+"_"+c)) {
					if(!fallback.containsKey(state))
						fallback.put(state, 0);
					state = fallback.get(state);
				}
				
				state = transition.containsKey(state+"_"+c) ? transition.get(state+"_"+c) : 0; 
				
				if(!output.getOrDefault(state, new HashMap<>()).isEmpty()) {
					for(Entry<Integer, Integer> e: output.get(state).entrySet()) {
						if(e.getKey() >= l && e.getKey() <= r) {
							sum += e.getValue();
						}
					}
				}
			}
			
			max = max < sum ? sum : max;
			min = min > sum ? sum : min;
		}
		
		System.out.print(min + " " + max);
	}

}
