package data_structures.linear;

public class Bitmask {

	static int setBit(int S, int j) { return S | 1 << j; }

	static int clearBit(int S, int j) { return S & ~(1 << j); }

	static int toggleBit(int S, int j) { return S ^ 1 << j; }

	static boolean isOn(int S, int j) { return (S & 1 << j) != 0; }

	static int turnOnLastZero(int S) { return S | S + 1; }
	
	static int turnOnLastConsecutiveZeroes(int S) { return S | S - 1; }
	
	static int turnOffLastBit(int S) { return S & S - 1; }
	
	static int turnOffLastConsecutiveBits(int S) { return S & S + 1; }

	static int lowBit(int S) { return S & -S; }

	static int setAll(int N) { return (1 << N) - 1; }

	static int modulo(int S, int N) { return (S & N - 1); }		 //S%N, N is a power of 2

	static boolean isPowerOfTwo(int S) { return (S & S - 1) == 0; }
}
