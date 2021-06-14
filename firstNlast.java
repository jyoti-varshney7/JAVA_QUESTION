//First and last occurrences of x

class GFG
{
ArrayList<Long> find(long arr[], int n, int x)
{
ArrayList<Long> al = new ArrayList<>();
long first = -1 , last = -1;
for(int i=0;i<n;i++){
if(x != arr[i])
continue;
if(first == -1)
first = i;
last = i;
}
al.add(first);
al.add(last);
return al;
}
}


