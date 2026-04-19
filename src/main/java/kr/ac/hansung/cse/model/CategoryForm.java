package kr.ac.hansung.cse.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryForm {

    private Long id;

    @NotBlank(message = "카테고리 이름을 입력하세요")
    @Size(max = 100, message = "100자 이내로 입력하세요")
    private String name;

    // ─────────────────────────────────────────────────────────────────
    // 변환 메서드 (DTO ↔ Entity)
    // ─────────────────────────────────────────────────────────────────

    /**
     * ProductForm → Product 엔티티 변환 (등록 시 사용)
     * id는 DB가 자동 생성하므로 포함하지 않습니다.
     */
    public Category toEntity() {
        return new Category(this.name);
    }

    /**
     * Product 엔티티 → ProductForm 변환 (수정 폼 초기화 시 사용)
     * 팩토리 메서드 패턴으로 구현하여 외부에서 직접 생성자를 호출하지 않도록 합니다.
     */
    public static CategoryForm from(Category category) {
        CategoryForm form = new CategoryForm();
        form.id = category.getId();
        form.name = category.getName();
        return form;
    }
}
