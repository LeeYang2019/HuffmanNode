///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (Huffman.java)
// File:             (MinPriorityQueue.java)
// Semester:         (Introduction to Data Structures) Fall 2016
//
// Author:           (Nhialee Yang nyang5@wisc.edu)
// CS Login:         (nhialee)
// Lecturer's Name:  (Alexander Brooks)
// Lab Section:      (N/A)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     (Yia Xiong)
// Email:            (yxiong58@wisc.edu)
// CS Login:         (yia)
// Lecturer's Name:  (Alexander Brooks)
// Lab Section:      (N/A)
//
//////////////////////////// 80 columns wide //////////////////////////////////

public class MinPriorityQueue implements MinPriorityQueueADT {
	// private fields
	private HuffmanNode[] huffnode;
	private int size;

	public MinPriorityQueue() 
	{
		// TODO Auto-generated constructor stub
	
		//contruct an array of huffman nodes storing 128 items
		huffnode = new HuffmanNode[128];
		size = 0; //used to track the array
	}

	@Override

	public HuffmanNode removeMin() throws PriorityQueueEmptyException 
	{
		// TODO Auto-generated method stub
		
		//if the queue is empty throw an exception
		if (size == 0) 
		{
			throw new PriorityQueueEmptyException();
		}

		//otherwise, obtain both the positions of the root and last node
		HuffmanNode root = huffnode[0];
		HuffmanNode last = huffnode[size - 1];
		
		//swap the positions of the nodes and decrement the size of the array
		huffnode[0] = last;
		size--;

		int pos = 0; //beginning at 0, the position of the parent node

		while (2 * pos + 1 < size) //while the position of a left child is less
								   //than the size of the array
		{
			int childIndex = 2 * pos + 1; //childIndex is initially left

			//the position of a right child is less than the size of the array
			//and the frequency of the left child is greater than the right child
			if (2 * pos + 2 < size && huffnode[childIndex].getFrequency() > 
			huffnode[2 * pos + 2].getFrequency()) 
			{
				childIndex = 2 * pos + 2; //childIndex is right 
			}
			
			//compare parent and children node frequencies and swap
			if (huffnode[pos].getFrequency() > huffnode[childIndex].getFrequency()) 
			{
				HuffmanNode temp = huffnode[pos];
				huffnode[pos] = huffnode[childIndex];
				huffnode[childIndex] = temp;
				
				//re-assign parent and child positions
				pos = childIndex;
			} 
			else 
			{
				break;
			}
		}
		
		//return the root
		return root;
	}

	@Override
	public void insert(HuffmanNode hn) throws PriorityQueueFullException 
	{
		// TODO Auto-generated method stub
		
		//if the queue is full
		if (size == huffnode.length) {
			throw new PriorityQueueFullException();
		}
		
		//if the queue is empty, add the node to the front and increment the size
		//of the array
		if (size == 0) 
		{
			huffnode[0] = hn;
			size++;
		} 
		else 
		{
			//otherwise, increment the size and add the node to the back of the 
			//queue
			size++;
			huffnode[size - 1] = hn;

			//obtain childIndex
			int childIndex = size - 1;

			//while childIndex is not 0
			while (childIndex != 0) 
			{	
				//obtain parentIndex
				int parentIndex = (childIndex - 1) / 2;
				
				//compare the frequencies of parent and child nodes and swap
				if (huffnode[childIndex].getFrequency() < 
						huffnode[parentIndex].getFrequency()) 
				{
					HuffmanNode temp = huffnode[parentIndex];
					huffnode[parentIndex] = huffnode[childIndex];
					huffnode[childIndex] = temp;

					//re-assign child and parent positions
					childIndex = parentIndex;

				} 
				else 
				{
					break;
				}
			}
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub

		if (size == 0) {
			return true;
		}
		return false;
	}

}
