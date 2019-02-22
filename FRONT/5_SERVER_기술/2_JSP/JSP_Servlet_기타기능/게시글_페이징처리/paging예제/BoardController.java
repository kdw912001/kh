
@Controller
public class BoardController {

	@Resource(name = "BoardService")
	private BoardService boardService;
	
	@RequestMapping("/paging.ok")
	public String getBoardList(@ModelAttribute("pagingDTO") PagingDTO pagingDTO
					, Model model
					, @RequestParam(value = "pageNo", required = false) String pageNo){
		pagingDTO.setPageSize(15); // 한 페이지에 보일 게시글 수
		pagingDTO.setPageNo(1); // 현재 페이지 번호
		if(StringUtils.isNotEmpty(pageNo)){
			pagingDTO.setPageNo(Integer.parseInt(pageNo));
		}
		pagingDTO.setBlockSize(10);
		pagingDTO.setTotalCount(rtsService.getRtsCount()); // 게시물 총 개수
		
		List<PagingDTO> boardList = boardService.getBoardList(pagingDTO);
		
		model.addAttribute("paging", pagingDTO);
		model.addAttribute("boardList", boardList);
		
		return "list";
	}
	
}
