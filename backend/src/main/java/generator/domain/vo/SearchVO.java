package generator.domain.vo;

import lombok.Builder;
import lombok.Data;

/**
 * SearchVO.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-18 : base version.
 */
@Data
@Builder
public class SearchVO {
    private Long id;
    private String title;
    private String content;
}
