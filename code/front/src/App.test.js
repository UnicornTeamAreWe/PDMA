import React from 'react';
import {cleanup, render} from '@testing-library/react';
import renderer from 'react-test-renderer'
import {UserInfo} from "./component/UserInfo";
import CheckboxWithLabel from "./component/CheckboxWithLabel";
import {fireEvent} from "@testing-library/dom";



// afterEach(cleanup)

// test('Get Title PDMA', () => {
//     const {getByText} = render(<App/>);
//     const linkElement = getByText('PDMA');
//     expect(linkElement).toBeInTheDocument();
// });

// describe('test UserInfo',()=>{
//     it('should has username and email', function () {
//         let user = {
//             username:'test',
//             email:'test@test.com'
//         }
//         const {getByText} = render(<UserInfo user={user} />)
//         const username = getByText('test');
//         const email = getByText('test@test.com')
//         expect(username.textContent).toEqual('test')
//         expect(email.textContent).toEqual('test@test.com')
//     });
// })
afterEach(cleanup);

it('CheckboxWithLabel changes the text after click', () => {
    const {queryByLabelText, getByLabelText} = render(
        <CheckboxWithLabel labelOn="On" labelOff="Off" />,
    );

    expect(queryByLabelText(/off/i)).toBeTruthy();

    fireEvent.click(getByLabelText(/off/i));

    expect(queryByLabelText(/on/i)).toBeTruthy();
});
