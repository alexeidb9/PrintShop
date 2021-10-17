

public class Article {
	private String title;
	private long articleId;
	
	public Article(GetPrint e) {
		title = e.getTitle();
		articleId = e.getArticleId();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}
}
