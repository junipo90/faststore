package com.fastcampus.faststore.entity;

import com.fastcampus.faststore.type.DiscountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/**
 * 할인 정책 Entity
 * 할인 타입과 액수를 가진다
 */
public class DiscountPolicy extends BaseEntity {

    private DiscountType discountType;

    private Long amount;

    // TODO: discountType에 따라 price에서 차액을 빼거나, 퍼센트 할인 가격을 반환하는 메서드를 완성하시오. DiscountPolicyTest를 성공시켜야 합니다.
    public Long getDiscountAmount(Long price) {
        if (this.discountType == DiscountType.PERCENT){
            return price - (price * this.amount / 100);
        }else {
            return price - this.amount;
        }
    }
}
