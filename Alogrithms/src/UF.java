import java.util.ArrayList;

public class UF {
	private int[] id;
	private int count;
	private int[] size;
	
	
	public UF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	
	/*
	 * this is for quick find
	 */
	public int find(int p) {
		return id[p];
	}

	
	/*
	 * this is for quick find
	 * put p and q into the same component
	 */
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		
		//Nothing to do if p and q are already 
		//in the same component
		if (pID == qID) return;
		
		//Rename p's component to q's component
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pID) {
				id[i] = qID;
			}	
		}
		count--;
	}
	
	public int findInQuickUnion(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		
		return id[p];
	}
	
	public void quickunion(int p, int q) {
		int pRoot = findInQuickUnion(p);
		int qRoot = findInQuickUnion(q);
		
		if (pRoot != qRoot) {
			id[qRoot] = pRoot;
			count--;
		}
	}
	
	public int findWithCompression(int p) {
		ArrayList al = new ArrayList<Integer>();
		while (p != id[p]) {
			al.add(p);
			p = id[p];
		}
		for (int x = 0; x < al.size(); x++) {
			id[(int) al.get(x)] = id[p];
		}
		return id[p];
	}
	
	public void weightedQuickunion(int p, int q) {
		int pRoot = findInQuickUnion(p);
		int qRoot = findInQuickUnion(q);
		
		if (pRoot != qRoot) {
			if(size[pRoot] > size[q]){
				id[qRoot] = pRoot;
				size[p] += size[q];
			}
			else {
				id[pRoot] = qRoot;
				size[q] += size[p];
			}
		count--;	
			
		}
	}
}

