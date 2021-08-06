// Given a binary tree , print the nodes in left to right manner as visible from below the tree

// Input Format
// Level order input for the binary tree will be given.

// Constraints
// No of nodes in the tree can be less than or equal to 10^7

// Output Format
// A single line containing space separated integers representing the bottom view of the tree

// Sample Input
// 1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
// Sample Output
// 4 2 6 3
// Explanation
// The tree looks like

//              1
//           /      \
//        2           3
//     /     \       /
//    4       5     6
// (Note that 5 and 6 are at the same position so we consider the right one to lower)


#include <bits/stdc++.h>
using namespace std;

class node{
    public:
        int data;
        node* left;
        node* right;

        node(int d){
            data=d;
            left=NULL;
            right=NULL;
        }
};

node* buildtree(node* root){
    int x;cin>>x;
    root=new node(x);
    queue<node* >q;
    q.push(root);
    while(!q.empty()){
        node* temp=q.front();
        q.pop();
        cin>>x;
        if(x!=-1){
            temp->left=new node(x);
            q.push(temp->left);
        }
        cin>>x;
        if(x!=-1){
            temp->right=new node(x);
            q.push(temp->right);
        }
    }    
    return root;
}
map<int,pair<int,int> >m;
void bottomview(node* root,int d=0,int h=0){
    if(root==NULL){
        return;
    }
    if(m[d].second<=h){
        m[d].second=h;
        m[d].first=root->data;
    }
    bottomview(root->left,d-1,h+1);
    bottomview(root->right,d+1,h+1);
}
int main() {
   node* root=NULL;
   root=buildtree(root);
   bottomview(root);
   for(auto i:m){
       cout<<i.second.first<<" ";
   } 
}
