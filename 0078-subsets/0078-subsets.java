class Solution 
{
    List<List<Integer>> ans;
    List<Integer> temp;
    void solve(int[] nums,int ind){
        if(ind>=nums.length){
            ans.add(new ArrayList(temp));
            return;
        }
        solve(nums,ind+1);
        temp.add(nums[ind]);
        solve(nums,ind+1);
        temp.remove(temp.size()-1);
        
    }
    public List<List<Integer>> subsets(int[] nums) 
{
        ans=new ArrayList();
        temp=new ArrayList();
        solve(nums,0);
        return ans;
    }
}