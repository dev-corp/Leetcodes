class Solution:
    def fill(self,image,row,col,val,newcolor):
        if row>=len(image) or col>=len(image[0]) or row<0 or col<0:
            return
            
        if image[row][col]!=val:
            return
        
        if image[row][col]==val:
            image[row][col]=newcolor
        
            self.fill(image,row-1,col,val,newcolor)
            self.fill(image,row,col+1,val,newcolor)
            self.fill(image,row+1,col,val,newcolor)
            self.fill(image,row,col-1,val,newcolor)
        
        return 
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        val=image[sr][sc]
        if val==newColor:
            return image 
        
        self.fill(image,sr,sc,val,newColor)
        return image
