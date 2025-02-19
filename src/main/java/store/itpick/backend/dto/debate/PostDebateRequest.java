package store.itpick.backend.dto.debate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDebateRequest {

    @NotNull(message = "keyword ID는 필수입니다.")
    private Long keywordId;

    @NotBlank(message = "title은 필수입니다.")
    private String title;

    @NotBlank(message = "Debate는 필수입니다.")
    private String content;

    private MultipartFile imageFile;

    private List<VoteOptionRequest> voteOptions;

    private boolean multipleChoice;

}

