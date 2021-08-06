// Given a binary tree and a number k, print out all root to leaf paths where the sum of all nodes value is same as the given number.

// Input Format
// First line contains the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL. Second line contains the number k.

// Constraints
// None

// Output Format
// Display the root to leaf path whose sum is equal to k.

// Sample Input
// 10 true 20 true 30 false false true 50 false false true 40 true 60 false false true 73 false false
// 60
// Sample Output
// 10 20 30
// Explanation
// The given tree is in pre order traversal. So convert it into binary tree and check root to leaf path sum.

#include <iostream>
#include<bits/stdc++.h>
using namespace std;
class node{
public:
    int data;
    node*left;
    node*right;
    node(int d)
    {data=d;
    left=NULL;
    right=NULL;
    }
    };
        void takeInput(node* &root) {
    string left, right;
    int data;
    cin >> data;
    root = new node(data);

    cin >> left;
    if(left == "true") {
        takeInput(root->left);
    }

    cin >> right;
    if(right == "true") {
        takeInput(root->right);
    }
}
void printroottoleaf(node*root,int sumsofar,int sum,vector <int> &path)
{
    if(root==NULL)
    {
        return ;
    }

    sumsofar+=root->data;
      path.push_back(root->data);
    if(sumsofar==sum && root->left==NULL && root->right==NULL)
    {
        for(int i=0;i<path.size();i++)
        {
            cout<<path[i]<<" ";
        }
    }
    


    printroottoleaf(root->left,sumsofar,sum,path);
    


    printroottoleaf(root->right,sumsofar,sum,path);
    
}
int main() {
    node*root1=NULL;
vector <int> path;
//int in[]={4, 8, 10, 12, 14, 20, 22};
//int lvl[]={20, 8, 22, 4, 12, 10, 14};
//root1=levelorder1(in,lvl,0,6,0);
takeInput(root1);
int sum;
cin>>sum;
printroottoleaf(root1,0,sum,path);
}
