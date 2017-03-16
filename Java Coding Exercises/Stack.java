class Stack_using_array {

     int top;
	 int arr[]=new int[1000];

    Stack_using_array()
	{
		top = -1;
	}

 */

class GfG
{
	/* The method push to push element into the stack */
	void push(int a, Stack_using_array ob)
			{
				//Your code
				ob.top++;
				ob.arr[top] = a;
			} 
         /*The method pop which return the element poped out of the stack*/
		int pop(Stack_using_array ob)
		{
			//Your code
			s = ob.arr[top];
			top--;
			return s;
		} 
}