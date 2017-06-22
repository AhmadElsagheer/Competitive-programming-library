package graphs.trees;

//Build the tree using the in-order and post-order traversals
public class TreeTraversal {

	 
	 static class Node { int val; Node left, right; Node(int x) { val = x; } }
	 
	 //idxOf is the idx of the specified node in the in[] array
	 static Node buildTree(int[] post, int[] in, int[] idxOf)
	 {
		 return buildTree(post, in, idxOf, 0, post.length - 1, 0, post.length - 1); //returns the root of the tree
	 }

	 
	 static Node buildTree(int[] post, int[] in, int[] idxOf, int b_post, int e_post, int b_in, int e_in)
	 {
		 if(b_post > e_post || b_in > e_in)
			 return null;
		 int idx = idxOf[post[e_post]];
		 Node root = new Node(post[e_post]);

		 int rightChildren = e_in - idx, leftChildren = idx - b_in;

		 root.right = buildTree(post, in, idxOf, e_post - rightChildren, e_post - 1, idx + 1, e_in);
		 root.left = buildTree(post, in, idxOf, b_post, b_post + leftChildren - 1, b_in, idx - 1);

		 return root;
	 }

}
