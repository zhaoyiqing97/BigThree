package generator.domain.vo;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * SearchVO.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-18 : base version.
 */
@Data
public class SearchVO {
    private Long id;
    private Map<String, List<String>> content;
}
