
public class ListFileSizeVisitor implements FileSystemVisitor<String> {

	
	@Override
	public String visitFile(FileNode f) {
		String text = f.getName()+" of "+f.getSize() + " bytes"+"\n";
		return text;
	}

	@Override
	public String visitDirectory(DirectoryNode d) {
		String struktur = "Directory " + d.getName() + " containing"+"\n";
		
		for(FileSystemNode node : d){
			struktur += node.accept(new ListFileSizeVisitor());
		}
		
		//System.out.println(struktur);
		return struktur;
	}

}
